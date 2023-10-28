package com.ssafy.board.model;

import java.util.List;

public class BoardDto {

	private int price;
	private String model;
	private String code;
	private String id;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BoardDto [price=" + price + ", model=" + model + ", code=" + code + ", id=" + id + "]";
	}

}
