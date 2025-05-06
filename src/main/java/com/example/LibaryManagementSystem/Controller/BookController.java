package com.example.LibaryManagementSystem.Controller;

import com.example.LibaryManagementSystem.Entity.Book;
import com.example.LibaryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

     @Autowired
    private BookService bookService;

     @GetMapping
    public List<Book> getAllBooks() {
         return bookService.findAll();
     }

     @GetMapping("/{id}")
      public Book getBookById(@PathVariable Long id) {
          return bookService.findById(id);
     }

     @PostMapping
    public Book addBook(@RequestBody Book book){
          return bookService.save(book);
     }

     @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book){
          return bookService.save(book);
     }

     @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
          bookService.deleteById(id);
     }

//     @PostMapping("/{bookId}/borrow/{user_id}")
//     public ResponseEntity<Book>  borrowBook(@PathVariable Long bookId,@PathVariable Long userID){
//          Book book = bookService.borrowBook(bookId,userID);
//          if(book != null){
//              return ResponseEntity.ok(book);
//          }else{
//              return ResponseEntity.badRequest().build();
//          }
//     }

    @PostMapping("/{bookId}/borrow/{user_id}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable("user_id") Long userID) {
        try {
            Book book = bookService.borrowBook(bookId, userID);
            if (book != null) {
                return ResponseEntity.ok(book);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            e.printStackTrace(); // or use a logger
            return ResponseEntity.status(500).build();
        }
    }


    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId){
          Book returnBook = bookService.returnBook(bookId);
          if(returnBook != null){
               return ResponseEntity.ok(returnBook);
          }else{
              return ResponseEntity.badRequest().build();
          }
     }
}
