package com.in28minutes.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaDao {

	@PersistenceContext
	EntityManager em;
	
	public Person findById(int id) {
		return em.find(Person.class, id);
	}
}
