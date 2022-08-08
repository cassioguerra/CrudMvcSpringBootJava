package com.example.SpringThymeleaf.service;

import com.example.SpringThymeleaf.entity.Book;
import com.example.SpringThymeleaf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {


    @Autowired
    BookRepository repository;

    public List<Book> findallBooks(){
return (List<Book>) repository.findAll();
    }

    public  Book findBookById(int id) {
        Optional<Book> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
                   return new Book();
         }


      public  Book addBook(Book book){
           return repository.save(book);
}

     public Book updateBook(Book book){
         Optional<Book> result = repository.findById(book.getId());
         Book existing = result.get();
         existing.setAuthor(book.getAuthor());
         existing.setName(book.getName());
         existing.setNoOfPages(book.getNoOfPages());
         existing.setPublication(book.getPublication());
       return   repository.save(existing);
     }

     public void deleteById(int id){
        repository.deleteById(id);
     }
}
