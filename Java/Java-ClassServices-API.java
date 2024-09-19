public class Car {

    private String id;
    private String name;

    public Car() {
    }

    public Car(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//Repository
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CarRepository {

    void deleteAll();

    void insertAll(List<Car> list);

    Mono<Car> save(Car car);

    Flux<Car> findAll();

    Mono<Car> findById(String id);

    Mono<Car> deleteById(String id);
}

//Service
package com.codility.external;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Flux<Car> findAll() {
        return carRepository.findAll();
    }

    public Mono<Car> findById(String id) {
        return carRepository.findById(id);
    }

    public Mono<Car> create(String name) {
        Car car = new Car(null, name);
        return carRepository.save(car);
    }

    public Mono<Car> update(String id, String name) {
        return carRepository
            .findById(id)
            //.map(null)
            .flatMap(existingCar -> {
                existingCar.setName(name);
                return carRepository.save(existingCar);
            });
    }

    public Mono<Car> delete(String id) {
        return carRepository
            .findById(id)
            .flatMap(existingCar -> carRepository.deleteById(id).thenReturn(existingCar));
    }
}

//Controller
package com.codility.external;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final MediaType mediaType = MediaType.APPLICATION_JSON;
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public Publisher<List<Car>> findAll() {
        return carService.findAll().collectList();
    }
    @GetMapping("{/id}")
    public Publisher<Car> findById(@PathVariable String id) {
        return carService.findById(id);
    }

    @PostMapping
    public Publisher<ResponseEntity<String>> create(@RequestBody Car car) {
        return carService.create(car.getName())
                .map(savedCar -> ResponseEntity
                        .created(URI.create("/car/" + savedCar.getId()))
                        .contentType(mediaType)
                        .body(savedCar.getId()));
    }

    @DeleteMapping("/{id}")
    public Publisher<ResponseEntity<Car>> deleteById(@PathVariable String id) {
        return carService.delete(id)
                .map(deletedCar -> ResponseEntity.ok()
                        .contentType(mediaType)
                        .body(deletedCar));
    }

    @PutMapping("/{id}")
    public Publisher<ResponseEntity<Car>> updateById(@PathVariable String id, @RequestBody Car car) {
        return carService.update(id, car.getName())
                .map(updatedCar -> ResponseEntity.ok()
                        .contentType(mediaType)
                        .body(updatedCar));
    }
}


