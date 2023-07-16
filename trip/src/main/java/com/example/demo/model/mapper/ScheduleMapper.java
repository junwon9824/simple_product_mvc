package com.example.demo.model.mapper;

import java.util.*;

import com.example.demo.model.Schedule;

public interface ScheduleMapper {
	List<Schedule> getAllSchedules();

	Schedule getScheduleById(int id);

	List<Schedule> getSchedulesByPlanId(int planId);

	void createSchedule(Schedule schedule);
	// 추가적인 메서드들
	// ...
}
