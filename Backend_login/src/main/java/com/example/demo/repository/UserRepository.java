package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the optional
	 */
	Optional<User> findByUsername(String username);
	
	/**
	 * Exists by username.
	 *
	 * @param username the username
	 * @return the boolean
	 */
	Boolean existsByUsername(String username);
	
	/**
	 * Exists by email.
	 *
	 * @param email the email
	 * @return the boolean
	 */
	Boolean existsByEmail(String email);
}
