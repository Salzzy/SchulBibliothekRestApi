package de.schule.schullib.schulbibliothek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/books/{id}")
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
	
	@GetMapping("/books/{titel}")
	public List<Book> getBooksByTitle(@RequestParam("titel") String title){
		
		return bookRepo.getBookByTitel(title);
		
	}
	
	
	
}
