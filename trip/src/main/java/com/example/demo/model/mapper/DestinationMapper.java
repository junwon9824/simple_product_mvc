package com.example.demo.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Destination;

@Mapper

public interface DestinationMapper {
	List<Destination> getAllDestinations();

	Destination getDestinationById(int id);

	void createDestination(Destination destination);
	// 추가적인 메서드들
	// ...
}
