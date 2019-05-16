package de.schule.schullib.schulbibliothek.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.schule.schullib.schulbibliothek.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByFirstNameIgnoreCaseContaining(String firstName);
	
	List<User> findByLastNameIgnoreCaseContaining(String lastName);
	
	List<User> findByLastNameIgnoreCaseContainingAndFirstNameIgnoreCaseContaining(String lastName, String firstName);
	
}
