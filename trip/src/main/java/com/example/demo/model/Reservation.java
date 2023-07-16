package com.example.demo.model;

public class Reservation {
    private int id;
    private int userId;
    private int planId;
    private String status;
	public Reservation(int id, int userId, int planId, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.planId = planId;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    // 생성자, getter, setter, toString 등의 메서드
    
    
}
