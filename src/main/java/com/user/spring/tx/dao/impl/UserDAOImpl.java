package com.user.spring.tx.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.user.spring.tx.dao.UserDAO;
import com.user.spring.tx.model.User;

@Repository
public class UserDAOImpl implements UserDAO 
{
	private static final String SELECT_QUERY = "select p from User p";


	@PersistenceContext
	private EntityManager entityManager;

	
	public void insertUser(User user) {
		entityManager.persist(user);
	}

	public List<User> findAllUsers() 
	{
		Query query = entityManager.createQuery(SELECT_QUERY);
		List<User> u = (List<User>) query.getResultList();
		return u;

	}


	public void deleteUser(User user) 
	{
		String DELETE_QUERY = "DELETE FROM User u where u.username= :name";
		
		Query query = entityManager.createQuery(DELETE_QUERY);
		query.setParameter("name", user.getUsername());
		
		System.out.println("Query is " +DELETE_QUERY);
		int delete = query.executeUpdate();
		
		entityManager.flush();
		
	}


	public void updateUser(User user) 
	{
		
		String UPDATE_QUERY = "UPDATE User u SET u.username= :Uname where u.name= :name";
		
		Query query = entityManager.createQuery(UPDATE_QUERY);
		query.setParameter("Uname", user.getUsername());
		query.setParameter("name", user.getName());
		
		System.out.println("Query is " +UPDATE_QUERY);
		
		query.executeUpdate();
		entityManager.flush();
		
	}


	
}
