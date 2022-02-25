package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Image;

/**
 * The Interface ImageRepository.
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {


	/**
	 * Find by tags.
	 *
	 * @param tags the tags
	 * @return the list
	 */
	List<Image> findByTags(String tags);

	
	/**
	 * Find by title.
	 *
	 * @param title the title
	 * @return the list
	 */
	List<Image> findByTitle(String title);

}
