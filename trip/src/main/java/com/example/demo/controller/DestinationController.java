package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Destination;
import com.example.demo.service.DestinationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/destinations")
public class DestinationController {
	private final DestinationServiceImpl destinationService;

	@Autowired
	public DestinationController(DestinationServiceImpl destinationService) {
		this.destinationService = destinationService;
	}

	@GetMapping
	public ResponseEntity<List<Destination>> getAllDestinations() {
		List<Destination> destinations = destinationService.getAllDestinations();
		return new ResponseEntity<>(destinations, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Destination> getDestinationById(@PathVariable int id) {
		Destination destination = destinationService.getDestinationById(id);
		if (destination == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(destination, HttpStatus.OK);
	}

	// 추가적인 메서드들
	// ...
}
