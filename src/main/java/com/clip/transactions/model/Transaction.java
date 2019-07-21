package com.clip.transactions.model;

import java.io.Serializable;
import java.util.UUID;

public class Transaction implements Serializable {

	private UUID id;

	private double amount;

	private String description;

	private String date;

	private int userId;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return  id + "," + amount + "," + description + "," + date
				+ "," + userId;
	}

}
