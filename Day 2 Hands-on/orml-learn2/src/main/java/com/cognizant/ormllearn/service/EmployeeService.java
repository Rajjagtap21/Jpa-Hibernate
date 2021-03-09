package com.cognizant.ormllearn.service;

import java.util.List;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormllearn.model.Employee;
import com.cognizant.ormllearn.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	EmployeeRepository employeeRepository;

	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");
		return employeeRepository.findById(id);
	}

	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");

	}

	@Transactional
	public List<Employee> getAllPermanentEmployees() {
		return employeeRepository.getAllPermanentEmployees();

	}

	public double getAvgSalary() {
		return employeeRepository.getAverageSalary();

	}

	@Transactional
	public List<Employee> getAllEmployeesNative() {
		return employeeRepository.getAllEmployeesNative();

	}

}
