package com.cognizant.ormllearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.ormllearn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	public Employee findById(int id);

	@Query(value = "SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();

	@Query(value = "SELECT * FROM employee", nativeQuery = true)
	List<Employee> getAllEmployeesNative();

	@Query(value = "SELECT AVG(e.salary) FROM Employee e")
	double getAverageSalary();

}
