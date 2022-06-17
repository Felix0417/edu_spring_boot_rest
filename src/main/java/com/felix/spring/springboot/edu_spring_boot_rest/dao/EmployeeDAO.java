package com.felix.spring.springboot.edu_spring_boot_rest.dao;



import com.felix.spring.springboot.edu_spring_boot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

//    public void saveEmployee(Employee employee);
//
//    Employee getEmployee(int id);
//
//    public void deleteEmployee(int id);
}
