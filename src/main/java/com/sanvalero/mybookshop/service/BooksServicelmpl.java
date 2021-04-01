package com.sanvalero.mybookshop.service;

import com.sanvalero.mybookshop.domain.Books;
import com.sanvalero.mybookshop.exception.BooksNotFoundException;
import com.sanvalero.mybookshop.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BooksServicelmpl implements BooksService{

    @Autowired
    private BooksRepository booksRepository;


    @Override
    public Set<Books> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Books findByTitle(String title) {
        return booksRepository.findByTitle(title);
    }

    @Override
    public Set<Books> findByCategory(String category) {
        return booksRepository.findByCategory(category);
    }

    @Override
    public Optional<Books> findById(long id) {
        return booksRepository.findById(id);
    }

    @Override
    public Books addBook(Books books) {
        return booksRepository.save(books);
    }

    @Override
    public Books modifyBook(long id, Books newBooks) {
        Books books = booksRepository.findById(id).orElseThrow(() -> new BooksNotFoundException(id));
        newBooks.setId(books.getId());
        return booksRepository.save(newBooks);
    }

    @Override
    public void deleteBook(long id) {
    booksRepository.findById(id).orElseThrow(() -> new BooksNotFoundException(id));
    booksRepository.deleteById(id);
    }
}
