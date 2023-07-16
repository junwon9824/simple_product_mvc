package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Destination;

 
public interface DestinationDao {
	List<Destination> getAllDestinations();

	Destination getDestinationById(int id);

	void createDestination(Destination destination);

	void updateDestination(Destination destination);

	void deleteDestination(int id);
	// 추가적인 메서드들
	// ...
}
