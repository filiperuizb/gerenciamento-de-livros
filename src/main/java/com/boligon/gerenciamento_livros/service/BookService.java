package com.boligon.gerenciamento_livros.service;


import com.boligon.gerenciamento_livros.entity.BookEntity;
import com.boligon.gerenciamento_livros.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);
    }

    public BookEntity save(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public BookEntity atualizar(Long id, BookEntity atualizarBook) {
        BookEntity entity = bookRepository.findById(id).get();
        entity.setTitle(atualizarBook.getTitle());
        entity.setAuthor(atualizarBook.getAuthor());
        entity.setAnoPublicacao(atualizarBook.getAnoPublicacao());

        return bookRepository.save(entity);
    }

}
