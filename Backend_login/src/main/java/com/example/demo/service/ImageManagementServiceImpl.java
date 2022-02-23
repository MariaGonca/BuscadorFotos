package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Image;
import com.example.demo.repository.ImageRepository;

/**
 * The Class ImageManagementServiceImpl.
 */
@Service
public class ImageManagementServiceImpl implements ImageManagementServiceI {

	/** The image repository. */
	@Autowired
	private ImageRepository imageRepository;

	/**
	 * Insert new image.
	 *
	 * @param newImage the new image
	 */
	@Override
	public void insertNewImage(Image newImage) {
		if (newImage != null && newImage.getIdImage() == null) {

			imageRepository.saveAndFlush(newImage);
		}

	}

	/**
	 * Update image.
	 *
	 * @param updatedImage the updated image
	 */
	@Override
	public void updateImage(Image updatedImage) {
		if (updatedImage != null && updatedImage.getIdImage() == null) {

			imageRepository.saveAndFlush(updatedImage);
		}

	}

	/**
	 * Delete image.
	 *
	 * @param deletedImage the deleted image
	 */
	@Override
	public void deleteImage(Image deletedImage) {
		if (deletedImage != null && deletedImage.getIdImage() != null) {

			imageRepository.delete(deletedImage);
		}

	}

	/**
	 * Search by tags.
	 *
	 * @param imageTag the image tag
	 * @return the list
	 */
	@Override
	public List<Image> searchByTags(String imageTag) {
		return imageRepository.findByTags(imageTag);

	}

	/**
	 * Search by title.
	 *
	 * @param imageTitle the image title
	 * @return the list
	 */
	@Override
	public List<Image> searchByTitle(String imageTitle) {
		return imageRepository.findByTitle(imageTitle);

	}

	/**
	 * Search all.
	 *
	 * @return the list
	 */
	@Override
	public List<Image> searchAll() {
		return imageRepository.findAll();
	}

	/**
	 * Search by id image.
	 *
	 * @param idImage the id image
	 * @return the image
	 */
	@Override
	public Image searchByIdImage(Long idImage) {
		return imageRepository.findByIdImage(idImage);
	}

}
