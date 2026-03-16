package com.boligon.gerenciamento_livros.controller;

import com.boligon.gerenciamento_livros.models.BookModel;
import com.boligon.gerenciamento_livros.services.BookService;
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
    public ResponseEntity<List<BookModel>> findAll(){
        List<BookModel> bookModels = bookService.findAll();
        return ResponseEntity.ok().body(bookModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> findById(@PathVariable Long id){
        Optional<BookModel> bookModel = bookService.findById(id);
        if(bookModel.isPresent()){
            return ResponseEntity.ok().body(bookModel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BookModel> save(@RequestBody BookModel bookModel){
        BookModel book = bookService.save(bookModel);
        return ResponseEntity.status(201).body(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
