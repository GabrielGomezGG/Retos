package com.gabrielgg.reto4.service;

import com.gabrielgg.reto4.model.Book;
import com.gabrielgg.reto4.model.entity.BookEntity;
import com.gabrielgg.reto4.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    private Book bookEntityToBook(BookEntity bookEntity){
        return new Book(bookEntity.getId(), bookEntity.getName(), bookEntity.getAuthor());
    }

    private BookEntity bookToBookEntity(Book book){
        return new BookEntity(book.id(), book.name(), book.author());
    }

    public List<Book> getAll(){
        return bookRepository.findAll().stream().map(this::bookEntityToBook).toList();
    }

    public Book save(Book book){
        return bookEntityToBook(bookRepository.save(bookToBookEntity(book)));
    }

    public Boolean update(Book book){

        if (bookRepository.existsById(book.id())){
            bookRepository.save(bookToBookEntity(book));
            return true;
        }
        return false;
    }

    public Boolean delete(Integer id){

        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
