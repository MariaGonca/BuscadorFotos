package com.example.demo.service;

import java.util.Optional;

import com.example.demo.models.Image;

/**
 * The Interface ImageManagementServiceI.
 */
public interface ImageManagementServiceI {

	/**
	 * Insert new image.
	 *
	 * @param newImage the new image
	 */
	public void insertNewImage(final Image newImage);
	
	/**
	 * Update image.
	 *
	 * @param updatedImage the updated image
	 */
	public void updateImage(final Image updatedImage);
	
	/**
	 * Delete image.
	 *
	 * @param deletedImage the deleted image
	 */
	public void deleteImage(final Image deletedImage);
	
	/**
	 * Search by tags.
	 *
	 * @param imageTag the image tag
	 * @return 
	 */
	public Optional<Image> searchByTags(final String imageTag);
	
	/**
	 * Search by title.
	 *
	 * @param imageTitle the image title
	 * @return 
	 */
	public Optional<Image> searchByTitle(final String imageTitle);
	
}
