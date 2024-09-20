package com.codility.tasks.hibernate.crud.solution;

import com.codility.tasks.hibernate.crud.ArticleDTO;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "article")
class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.Identity)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "content", length = 50, nullable = false)
    private String content;
}



package com.codility.tasks.hibernate.crud.solution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

interface ArticleRepository extends JpaRepository <Article, Long>{

}


package com.codility.tasks.hibernate.crud.solution;

import com.codility.tasks.hibernate.crud.ArticleDTO;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.stream.*;

@Service
class ArticleService {

    private final ArticleRepository articleRepository
    @Autowired
    public ArticleRepository(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    } 
    public Optional<ArticleDTO> findById(Long id) {
        return articleRepository.findById(id);
    }

    public List<ArticleDTO> findByTitle(String title) {
        return articleRepository.findById(title);
    }

    public Long create(ArticleDTO articleDTO) {
        return articleRepository.save(articleDTO);
    }

    public void update(Long id, ArticleDTO articleDTO) {
        Optional<ArticleDTO> up = articleRepository.findById(id);
        if(up.IsPresent()){
            up.update();
        }
        else{
            throw new ArticleNotFound("Article not found")
        }
        return articleRepository.
    }

    public void delete(Long id) {
        return articleRepository.deleteById(id);
    }

}


