package book.example.BookApi.repository;


import book.example.BookApi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

/*
*Repository interface for Book Model
*/
public interface BookRepository extends JpaRepository<Book, Long> {
}
