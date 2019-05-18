package de.schule.schullib.schulbibliothek.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.schule.schullib.schulbibliothek.entity.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Integer> {

	
//	@Query("SELECT b FROM Book b WHERE b.title like %:title%")
//	List<Book> findAllBooksByTitle(@Param("title") String title);
	
	List<Book> findByTitleIgnoreCaseContaining(String title);
	
}
