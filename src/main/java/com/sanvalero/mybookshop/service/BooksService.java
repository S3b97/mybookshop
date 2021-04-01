package com.sanvalero.mybookshop.service;

import com.sanvalero.mybookshop.domain.Books;

import java.util.Optional;
import java.util.Set;

public interface BooksService {

    Set<Books> findAll();
    Books findByTitle(String title);
    Set<Books> findByCategory(String category);

    Optional<Books> findById(long id);
    Books addBook(Books books);
    Books modifyBook(long id, Books newBooks);
    void deleteBook(long id);

}
