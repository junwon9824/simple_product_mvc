package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Destination;
import com.example.demo.model.Plan;
import com.example.demo.model.mapper.DestinationMapper;
import com.example.demo.model.mapper.PlanMapper;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanMapper planMapper;

	@Override
	public List<Plan> getAllPlans() {
		return planMapper.getAllPlans();
	}
 

	// 추가적인 메서드들
	// ...
}
