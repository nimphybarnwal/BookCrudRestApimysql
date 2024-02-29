package com.bookmysqlrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmysqlrestapi.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
