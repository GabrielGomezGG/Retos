package com.gabrielgg.reto4.controller;

import com.gabrielgg.reto4.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gabrielgg.reto4.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    private BookService BookService;


    @GetMapping()
    public List<Book> getBooks() {
        return BookService.getAll();
    }

    @PostMapping()
    public ResponseEntity<Book> setBooks(@RequestBody Book book) {
        BookService.save(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping()
    public ResponseEntity<Book> updateBooks(@RequestBody Book book) {
        if (BookService.update(book)) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBooks(@PathVariable Integer id) {
        if (BookService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
//    private ArrayList<Book> books = new ArrayList<>();
//
//    public BookController() {
//        books.add(new Book(1,"El Quijote", "Cervantes"));
//        books.add(new Book(2,"El Aleph", "Borges"));
//    }
//
//    @GetMapping()
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    @PostMapping()
//    public ResponseEntity<Book> setBooks(@RequestBody Book book) {
//        books.add(book);
//        return ResponseEntity.ok(book);
//    }
//
//    @PutMapping()
//    public ResponseEntity<Book> updateBooks(@RequestBody Book book) {
//        for(int i = 0; i < books.size(); i++) {
//            if(books.get(i).id().equals(book.id())) {
//                books.set(i, book);
//                return ResponseEntity.ok(book);
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Book> deleteBooks(@PathVariable Integer id) {
//        for(int i = 0; i < books.size(); i++) {
//            if(books.get(i).id().equals(id)) {
//                books.remove(i);
//                return ResponseEntity.ok().build();
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
}
