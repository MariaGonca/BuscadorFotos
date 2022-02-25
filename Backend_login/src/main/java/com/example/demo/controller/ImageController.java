package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Image;
import com.example.demo.repository.ImageRepository;

/**
 * The Class ImageController.
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ImageController {

	/** The image service. */
	@Autowired
	private ImageRepository imageService;

	/**
	 * Gets the all images.
	 *
	 * @param title the title
	 * @return the all images
	 */
	@GetMapping("/images")
	public ResponseEntity<List<Image>> printAllImages(@RequestParam(required = false) String title) {
		try {
			List<Image> images = new ArrayList<Image>();

			if (title == null)
				imageService.findAll().forEach(images::add);
			else
				imageService.findByTitle(title).forEach(images::add);

			if (images.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(images, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/images/animales")
	public ResponseEntity<List<Image>> getImageByTagsAnimales() {
		try {
			String tags = "animales";
		List<Image> image = imageService.findByTitle(tags);
			imageService.findByTags(tags).forEach(image::add);
			
		if (image.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(image, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@GetMapping("/images/flores")
	public ResponseEntity<List<Image>> getImageByTagsFlores() {
		try {
			String tags = "flores";
		List<Image> image = imageService.findByTitle(tags);
			imageService.findByTags(tags).forEach(image::add);
			
		if (image.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(image, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@GetMapping("/images/musica")
	public ResponseEntity<List<Image>> getImageByTagsMusica() {
		try {
			String tags = "musica";
		List<Image> image = imageService.findByTitle(tags);
			imageService.findByTags(tags).forEach(image::add);
			
		if (image.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(image, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}


	@PostMapping("/images/add")
	public ResponseEntity<Image> addImage(@RequestBody Image image) {
		try {
			imageService.save(image);
			return new ResponseEntity<>(image, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/images/delete/{idImage}")
	public ResponseEntity<HttpStatus> deleteImage(@PathVariable("idImage") Long idImage) {
		try {
			imageService.deleteById(idImage);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/images/modify/{idImage}")
	public ResponseEntity<Image> updateImagen(@PathVariable("idImage") Long idImage, @RequestBody Image imagen) {
		Optional<Image> image = imageService.findById(idImage);

		if (image.isPresent()) {
			Image images = image.get();
			images.setTitle(images.getTitle());
			images.setUrl(images.getUrl());
			return new ResponseEntity<>(imageService.save(imagen), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}