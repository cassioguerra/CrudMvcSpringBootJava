package com.example.SpringThymeleaf.repository;

import com.example.SpringThymeleaf.entity.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book , Integer> {


}
