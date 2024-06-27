package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.entity.Professor;
import com.example.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService ds;
	
	@PostMapping
	public ResponseEntity<Department> Createdept(@RequestBody Department d) {
		//TODO: process POST request
		return ds.createDepartment(d);
	}
	
	@PostMapping("/professors")
	public ResponseEntity<Professor> Createprof(@RequestBody Professor p) {
		return ds.createProfessor(p);
	}
	
	
	@PostMapping("/{departmentId}/professors/{professorId}")
	public ResponseEntity<Department> alotProfDept(@PathVariable Long departmentId,@PathVariable Long professorId) {
		return ds.assignProfessorToDepartment(departmentId, professorId);
	}
	
	@GetMapping
	public ResponseEntity<List<Department>> getDept() {
		return ds.readDepartment();
	}
	
	@GetMapping("/professors/{departmentName}")
	public ResponseEntity<List<Professor>> getProfDept(@PathVariable String departmentName) {
		return ds.readprofessorByDepartment(departmentName);
	}
}
