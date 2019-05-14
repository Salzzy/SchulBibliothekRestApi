package de.schule.schullib.schulbibliothek.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.schule.schullib.schulbibliothek.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	
	@Query("SELECT b.titel FROM Buch WHERE b.titel like %:titel%")
	List<Book> getBookByTitel(@Param("titel")String titel);
	
}
