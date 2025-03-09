package book.example.BookApi.controller;


import book.example.BookApi.model.Book;
import book.example.BookApi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /*
    * Create a new book
    *
    * @param book the book to create
    * @return the ResponseEntity with status code 200 (ok) and with the body of the new book
    * */
    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book newBook = bookService.saveBook(book);
        return ResponseEntity.ok(newBook);
    }

    /*
    * Get all books
    *
    * @return the ResponseEntity with status code (ok) and with the body of the list of books
    * */
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /*
    * Get a book by ID
    *
    * @param id the ID of the book to get
    * @return the ResponseEntity with status 200 (OK) and with the body of the book, or with status 404 (Not Found) if the book does not exist
    *
    * */
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
    * Update a book by ID
    *
    * @param id the ID of the book to update
    * @param book the updated book
    * @return the ResponseEntity with status 200 (OK)and with the body of the updated book, or with status 404 (Not found) if the book does not exist
    * */

    @PutMapping("books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    /*
    * Delete a book by ID
    *
    * @param id the ID of the book to delete
    * @return the ResponseEntity with status 200 (OK) and with body of the message "Book deleted successfully"
    * */

    @DeleteMapping("books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
