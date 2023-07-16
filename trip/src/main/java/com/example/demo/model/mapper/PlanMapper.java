package com.example.demo.model.mapper;

import java.util.List;

import com.example.demo.model.Plan;

public interface PlanMapper {
	Plan getPlanById(int id);

	List<Plan> getAllPlans();

	void createPlan(Plan plan);

	void updatePlan(Plan plan);

	void deletePlan(int id);

	// 추가적인 메서드들
	// ...
}
