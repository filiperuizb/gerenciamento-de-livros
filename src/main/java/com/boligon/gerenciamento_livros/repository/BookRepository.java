package com.boligon.gerenciamento_livros.repository;

import com.boligon.gerenciamento_livros.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
