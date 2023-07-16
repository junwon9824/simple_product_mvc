package com.example.demo.model;

 
import java.time.LocalDateTime;

public class Schedule {
    private int id;
    private int planId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Schedule(int id, int planId, LocalDateTime startTime, LocalDateTime endTime, String description) {
		super();
		this.id = id;
		this.planId = planId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

    // 생성자, getter, setter, toString 등의 메서드
    
    
}
