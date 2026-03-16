package com.boligon.gerenciamento_livros.repositories;

import com.boligon.gerenciamento_livros.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> {
}
