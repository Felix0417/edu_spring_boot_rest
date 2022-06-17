package com.felix.spring.springboot.edu_spring_boot_rest.dao;


import com.felix.spring.springboot.edu_spring_boot_rest.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        Session session = entityManager.unwrap(Session.class);
        List<Employee> allEmployees = session.createQuery(" from Employee", Employee.class).getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        entityManager.unwrap(Session.class).saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Employee "+
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
