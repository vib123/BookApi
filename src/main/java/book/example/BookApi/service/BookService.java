package book.example.BookApi.service;


import book.example.BookApi.model.Book;
import book.example.BookApi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* Service class for managing Book Model
* */
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /*
    * Save a Book
    *
    * @param book the model to save
    * @return the persisted model
    * */
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /*
    * Get all the books
    *
    *  @return the list of models
    * */

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /*
    * Get one book by ID
    *
    * @param id the ID of the model
    * @return the model
    * */

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    /*
    * Update a book
    *
    * @param id the ID of the model
    * @param updateBook the updated model
    * @return the updated model
    * */

    public Book updateBook(Long id, Book updateBook) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setName(updateBook.getName());
            book.setPrice(updateBook.getPrice());
            book.setType(updateBook.getType());
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book is not available");
        }
    }

    /*
    * Delete a book by ID
    *
    * @param id the ID of the model
    * */

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
