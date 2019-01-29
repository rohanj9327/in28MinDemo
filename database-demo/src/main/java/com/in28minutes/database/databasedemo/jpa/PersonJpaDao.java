package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	public Person insert(Person p) {
		return em.merge(p);
	}
	
	public Person update(Person p) {
		return em.merge(p);
	}
	
	public void deleteById(int id) {
		em.remove(em.find(Person.class, id));
	}
	
	public List<Person> findall() {
		TypedQuery<Person> namedQuery = em.createNamedQuery("all_person",Person.class);
		return namedQuery.getResultList();
	}
}
