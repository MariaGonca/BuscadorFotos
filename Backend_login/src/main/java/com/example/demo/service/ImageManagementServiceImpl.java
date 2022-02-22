package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Image;
import com.example.demo.repository.ImageRepository;

@Service
public class ImageManagementServiceImpl implements ImageManagementServiceI {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public void insertNewImage(Image newImage) {
	if(newImage != null && newImage.getID() == null) {
		
		imageRepository.saveAndFlush(newImage);
	}
		
	}

	@Override
	public void updateImage(Image updatedImage) {
		if(updatedImage != null && updatedImage.getID() == null) {
			
			imageRepository.saveAndFlush(updatedImage);
		}
		
	}

	@Override
	public void deleteImage(Image deletedImage) {
		if(deletedImage != null && deletedImage.getID() == null) {
			
			imageRepository.delete(deletedImage);
		}

		
	}

	@Override
	public Optional<Image> searchByTags(String imageTag) {
		return imageRepository.findByTags(imageTag);
		
	}

	@Override
	public Optional<Image> searchByTitle(String imageTitle) {
		return imageRepository.findByTitle(imageTitle);
		
	}




	

}
