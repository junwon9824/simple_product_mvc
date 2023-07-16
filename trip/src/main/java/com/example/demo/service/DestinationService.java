package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Destination;

 
public interface DestinationService {
	List<Destination> getAllDestinations();

	Destination getDestinationById(int id);
	// 추가적인 메서드들
	// ...
}
