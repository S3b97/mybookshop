package com.sanvalero.mybookshop.repository;

import com.sanvalero.mybookshop.domain.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long> {

    Set<Books> findAll();
    Books findByTitle(String title);
    Set<Books> findByCategory(String category);




}
