package com.example.demo.entity;

import jakarta.persistence.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	private String name; 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("department")
	private List<Professor> professors;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Professor> getProfessor() {
		return professors;
	}

	public void setProfessor(List<Professor> professor) {
		this.professors = professor;
	}

	public Department(Long departmentId, String name, List<Professor> professor) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.professors = professor;
	}

	public Department() {
		super();
	}
	
}
