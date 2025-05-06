package com.example.LibaryManagementSystem.Service;

import com.example.LibaryManagementSystem.Entity.Book;
import com.example.LibaryManagementSystem.Entity.User;
import com.example.LibaryManagementSystem.Repository.BookRepo;
import com.example.LibaryManagementSystem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {


    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private UserRepo userRepo;


    public List<Book> findAll(){
         return bookRepo.findAll();
    }

    public Book findById(Long id){
        return bookRepo.findById(id).orElse(null);
    }

    public Book save(Book book){
          return bookRepo.save(book);
    }

    public void deleteById(Long id){
           bookRepo.deleteById(id);
    }

    public Book borrowBook(Long bookId,Long userId){
         Book book = findById(bookId);
         User user = userRepo.findById(userId).orElse(null);

         if(book != null && !book.isBorrowed() && user != null){
              book.setBorrowedBy(user);
              book.setBorrowed(true);
              return  save(book);
         }
         return  null;
    }
     public Book returnBook(Long bookId){
          Book book = findById(bookId);
          if(book != null && book.isBorrowed()){
               book.setBorrowedBy(null);
               book.setBorrowed(false);
               return  save(book);
         }
          return null;
     }

}
