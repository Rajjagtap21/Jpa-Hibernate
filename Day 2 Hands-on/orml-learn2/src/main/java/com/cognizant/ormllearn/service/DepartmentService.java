package com.cognizant.ormllearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormllearn.model.Department;
import com.cognizant.ormllearn.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department getDepartment(int id) {
		return departmentRepository.findById(id);
	}

}
