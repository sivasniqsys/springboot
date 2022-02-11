package com.example.democrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.democrud.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Employee> getEmployeeList() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		return employee; 
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", employeeId);
		query.executeUpdate();
	}

}
