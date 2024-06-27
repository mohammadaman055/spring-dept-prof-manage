package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Professor;
//import com.example.demo.entity.Professors;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	public List<Professor> findByDepartmentsNameOrderByNameDesc(String departmentName);
}
