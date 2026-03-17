package com.boligon.gerenciamento_livros.controller;

import com.boligon.gerenciamento_livros.entity.BookEntity;
import com.boligon.gerenciamento_livros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookEntity>> findAll(){
        List<BookEntity> bookEntities = bookService.findAll();
        return ResponseEntity.ok().body(bookEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> findById(@PathVariable Long id){
        Optional<BookEntity> bookModel = bookService.findById(id);
        if(bookModel.isPresent()){
            return ResponseEntity.ok().body(bookModel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BookEntity> save(@RequestBody BookEntity bookEntity){
        BookEntity book = bookService.save(bookEntity);
        return ResponseEntity.status(201).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        bookService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
    
}
