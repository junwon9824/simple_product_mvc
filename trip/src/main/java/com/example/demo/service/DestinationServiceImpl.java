package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DestinationDao;
import com.example.demo.model.Destination;

@Service
public class DestinationServiceImpl implements DestinationService {
	private final DestinationDao destinationDao;

	@Autowired
	public DestinationServiceImpl(DestinationDao destinationRepository) {
		this.destinationDao = destinationRepository;
	}

	@Override
	public List<Destination> getAllDestinations() {
		return destinationDao.getAllDestinations();
	}

	@Override
	public Destination getDestinationById(int id) {
		return destinationDao.getDestinationById(id);
	}

	// 추가적인 메서드들
	// ...
}
