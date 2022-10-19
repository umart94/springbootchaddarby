package com.example.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entities.Employee;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

	private EntityManager theEntityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		super();
		this.theEntityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session currentSession = theEntityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theEmployeeId) {
		// TODO Auto-generated method stub
		Session currentSession = theEntityManager.unwrap(Session.class);
		Employee theEmployee = currentSession.get(Employee.class,theEmployeeId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Session currentSession = theEntityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = theEntityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}
