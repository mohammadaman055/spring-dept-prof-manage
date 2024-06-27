package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Professor;
import com.example.demo.repo.DepartmentRepository;
import com.example.demo.repo.ProfessorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {
	@Autowired
	private DepartmentRepository dr;
	
	@Autowired
	private ProfessorRepository pr;
	
	public ResponseEntity<Department> createDepartment(Department d) {
		return ResponseEntity.status(201).body(dr.save(d));
	}
	
	public ResponseEntity<Professor> createProfessor(Professor p){
		return ResponseEntity.status(201).body(pr.save(p));
	}
	
	public ResponseEntity<Department> assignProfessorToDepartment (Long departmentId,Long professorId){
		Department department = dr.findById(departmentId).get();
		Professor professor = pr.findById(professorId).get();
		department.getProfessor().add(professor);
		return ResponseEntity.ok().body(dr.save(department));
	}
	
	public ResponseEntity<List<Department>> readDepartment(){
		return ResponseEntity.ok().body(dr.findAll());
	}
	
	public ResponseEntity<List<Professor>> readprofessorByDepartment(String departmentName){
		return ResponseEntity.ok().body(pr.findByDepartmentsNameOrderByNameDesc(departmentName));
	}
}
