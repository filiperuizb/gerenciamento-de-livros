package com.boligon.gerenciamento_livros.services;


import com.boligon.gerenciamento_livros.models.BookModel;
import com.boligon.gerenciamento_livros.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> findAll() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> findById(Long id) {
        return bookRepository.findById(id);
    }

    public BookModel save(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
