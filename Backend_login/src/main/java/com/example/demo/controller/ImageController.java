package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Image;
import com.example.demo.service.ImageManagementServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ImageController {
	
	@Autowired
	ImageManagementServiceImpl imageService;
	

	@GetMapping("/images")
	public ResponseEntity<List<Image>> getAllImages(@RequestParam(required = false) String title) {
		try {
			List<Image> images = new ArrayList<Image>();

			if (title == null)
				imageService.searchAll().forEach(images::add);
			else
				imageService.searchByTitle(title).forEach(images::add);

			if (images.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(images, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}

