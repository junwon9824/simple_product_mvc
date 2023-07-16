package com.example.demo;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Plan;
import com.example.demo.model.mapper.PlanMapper;

@Component
public class TestDataSeeder {
    private final PlanMapper planMapper;
    private final Logger logger;

    @Autowired
    public TestDataSeeder(PlanMapper planMapper) {
        this.planMapper = planMapper;
        this.logger = LoggerFactory.getLogger(TestDataSeeder.class);
    }

    public void seedTestData() {
        // Test data creation
        Plan plan1 = new Plan(0, "Plan Name 1", "Plan Description 1", 1, LocalDateTime.now());
        Plan plan2 = new Plan(0, "Plan Name 2", "Plan Description 2", 2, LocalDateTime.now());

        // Persist the test data using MyBatis mapper
        planMapper.createPlan(plan1);
        planMapper.createPlan(plan2);

        logger.debug("Test data seeding completed.");
    }
}
