//Loops in JavaScript

//Classical For Loop
for (let i = 0; i < 5; i++) {
    console.log(i);    
}

//For..of Loop
const techlanguages = ["C#", "Java", "Python"];
for (const techlanguage of techlanguages) {
    console.log(techlanguage);
}

//forEach() Array Method
const digits = [20, 30, 40, 50];
digits.forEach(digit => {
    console.log(digit);
});

//For..in Loop
const user = {  name: "Ruby",
                role: "Software Engineer",
                Techlanguage: "Ruby"
            };
for (const key in user) {
    console.log(`${key}: ${user[key]}`);
}

//While Loop
let counter = 10;
while (counter < 15) {
    console.log(counter);
    counter++;
}

//Do..while
let count = 0;

do {
   console.log(count);
   count++; 
} while (count < 5);

//Array Methods(map, filter, reduce)
const numbers = [1, 2, 3, 4, 5];

const doubledNumbers = numbers.map(number => number * 2);
console.log(doubledNumbers);

