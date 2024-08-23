package com.pxc.todoapp_jsp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	@Size(min = 2, message = "Please enter 2 or more characters.")
	private String title;
	
	@Size(min = 2, message = "Please enter 2 or more characters.")
	private String description;
	
	private LocalDate createdAt;
	private LocalDate targetDate;
	private boolean status;
	private LocalDate lastUpdated;
	
	public Todo() {
	}

	public Todo(int id, String username, String title, String description, LocalDate createdAt,
			LocalDate targetDate, boolean status, LocalDate lastUpdated) {
		this.id = id;
		this.username = username;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.targetDate = targetDate;
		this.status = status;
		this.lastUpdated = lastUpdated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", title=" + title + ", description=" + description
				+ ", createdAt=" + createdAt + ", targetDate=" + targetDate + ", status=" + status + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
	
}
