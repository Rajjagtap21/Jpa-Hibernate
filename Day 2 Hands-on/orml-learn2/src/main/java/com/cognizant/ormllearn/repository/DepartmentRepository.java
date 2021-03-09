package com.cognizant.ormllearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormllearn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
	Department findById(int id);

}
