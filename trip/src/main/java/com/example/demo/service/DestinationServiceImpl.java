package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Destination;
import com.example.demo.model.mapper.DestinationMapper;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	private DestinationMapper destinationMapper;

	@Override
	public List<Destination> getAllDestinations() {
		return destinationMapper.getAllDestinations();
	}
 
	// 추가적인 메서드들
	// ...
}
