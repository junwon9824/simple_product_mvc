package com.example.demo.model;

public class Review {
    private int id;
    private int userId;
    private int planId;
    private String content;
    private int rating;
	public Review(int id, int userId, int planId, String content, int rating) {
		super();
		this.id = id;
		this.userId = userId;
		this.planId = planId;
		this.content = content;
		this.rating = rating;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

    // 생성자, getter, setter, toString 등의 메서드
    
    
}
