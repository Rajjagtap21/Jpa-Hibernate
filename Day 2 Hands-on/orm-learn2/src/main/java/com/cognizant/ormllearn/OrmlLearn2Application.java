package com.cognizant.ormllearn;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormllearn.model.Department;
import com.cognizant.ormllearn.model.Employee;
import com.cognizant.ormllearn.model.Skill;
import com.cognizant.ormllearn.service.DepartmentService;
import com.cognizant.ormllearn.service.EmployeeService;
import com.cognizant.ormllearn.service.SkillService;

@SpringBootApplication
public class OrmlLearn2Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmlLearn2Application.class);
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OrmlLearn2Application.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		// testGetEmployee();
		// testAddEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		// testAddSkillToEmployee();
		// testGetAllPermanentEmployees();
		testGetAvgSalary();
		// testGetAllEmployeesNative();
		LOGGER.info("Inside main method");
	}

	private static void testGetEmployee() {

		LOGGER.info("Start");

		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("____End____");

	}

	public static void testAddEmployee() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("Raj");
		e.setSalary(new BigDecimal(50000));
		e.setDate(Date.valueOf("1998-11-11"));
		e.setPermanent(true);
		Department d = departmentService.getDepartment(1);
		e.setDepartment(d);
		employeeService.save(e);
		LOGGER.debug("Employee:{}", e);
		LOGGER.debug("Department:{}", e.getDepartment());
		LOGGER.info("____End____");

	}

	public static void testUpdateEmployee() {
		Employee emp1 = employeeService.get(1);
		Department department = departmentService.getDepartment(2);
		emp1.setDepartment(department);
		employeeService.save(emp1);
	}

	public static void testGetDepartment() {
		Department dept1 = departmentService.getDepartment(1);
		LOGGER.debug("Department:{}", dept1);
		LOGGER.debug("Employee:{}", dept1.getEmployeeList());

	}

	public static void testAddSkillToEmployee() {
		Employee employee = employeeService.get(4);
		Skill skill = skillService.getSkillById(1);
		employee.getSkillList().add(skill);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee.getSkillList());

	}

	public static void testGetAllPermanentEmployees() {

		LOGGER.info("Start");

		List<Employee> employees = employeeService.getAllPermanentEmployees();

		LOGGER.debug("Permanent Employees:{}", employees);

		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));

		LOGGER.info("____End____");

	}

	public static void testGetAvgSalary() {
		LOGGER.info("Start");
		double avgSalary = employeeService.getAvgSalary();
		//LOGGER.debug("Average Salary:", avgSalary);
		System.out.println("Average Salary:" + avgSalary);
		LOGGER.info("____End____");

	}

	public static void testGetAllEmployeesNative() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllEmployeesNative();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(emp -> LOGGER.debug("Skills:{}", emp.getSkillList()));
		employees.forEach(emp -> {
			System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getDepartment().getName());
		});
		LOGGER.info("____End____");
	}

}
