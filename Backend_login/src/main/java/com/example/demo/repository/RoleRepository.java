package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.*;

/**
 * The Interface RoleRepository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the optional
	 */
	Optional<Role> findByName(ERole name);
}
