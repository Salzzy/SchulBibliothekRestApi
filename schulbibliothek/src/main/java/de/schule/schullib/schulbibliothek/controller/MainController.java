package de.schule.schullib.schulbibliothek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.schule.schullib.schulbibliothek.entity.Book;
import de.schule.schullib.schulbibliothek.rest.BookRepository;

@RestController
@RequestMapping("/api")
public class MainController {

	BookRepository bookRepo;
	
	public MainController(BookRepository theBookRepo) {
		bookRepo = theBookRepo;
	}
	
	@GetMapping("/books")
	public List<Book> findAllBooks() {
		return bookRepo.findAll();
	}
	
	@GetMapping("/book")
	public Book getBookById(@RequestParam("id")int theId) {
		
		Optional<Book> result = bookRepo.findById(theId);
		
		Book theBook = null;
		
		if(result.isPresent()) {
			theBook = result.get();
		}
		else {
			throw new RuntimeException();
		}
		return theBook;
	}
	
	@GetMapping("/bookstitle")
	public List<Book> getBooksByTitle(@RequestParam(name = "title") String title){
		
		return bookRepo.findByTitleIgnoreCaseContaining(title);
		
	}
	
	@GetMapping("/user")
	public User getUserById(@RequestParam("id")int theId) {
		Optional<User> result = userRepo.findById(theId);
		
		User theUser = null;
		
		if(result.isPresent()) {
			theUser = result.get();
		}
		else {
			throw new RuntimeException();
		}
		return theUser;
	}
	
}
