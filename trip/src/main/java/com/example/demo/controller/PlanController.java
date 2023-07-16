package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Destination;
import com.example.demo.model.Plan;
import com.example.demo.service.DestinationService;
import com.example.demo.service.DestinationServiceImpl;
import com.example.demo.service.PlanService;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {
	@Autowired
	private PlanService planService;

	@GetMapping
	public ResponseEntity<List<Plan>> getAllPlans() {
		List<Plan> plans = planService.getAllPlans();
		return new ResponseEntity<>(plans, HttpStatus.OK);
	}

	// 추가적인 메서드들
	// ...
}
