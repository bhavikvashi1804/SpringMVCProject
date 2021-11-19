package com.bhavik.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "field")
	private String field;

	@Column(name = "rating")
	private int rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public InstructorDetail() {

	}

	public InstructorDetail(String field, int rating) {

		this.field = field;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", field=" + field + ", rating=" + rating + "]";
	}

}