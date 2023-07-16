package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Destination;
import com.example.demo.service.DestinationService;
import com.example.demo.service.DestinationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/destinations")
public class DestinationController {
	@Autowired
	private DestinationService destinationService;

	@GetMapping
	public ResponseEntity<List<Destination>> getAllDestinations() {
		List<Destination> destinations = destinationService.getAllDestinations();
		return new ResponseEntity<>(destinations, HttpStatus.OK);
	}

	// 추가적인 메서드들
	// ...
}
