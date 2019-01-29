package com.in28minutes.database.databasedemo.jdbc;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person",new BeanPropertyRowMapper(Person.class));
	}
	
	public Person findById(int id){
		return (Person) jdbcTemplate.queryForObject("select * from person where id =?",new Object[]{id},new BeanPropertyRowMapper(Person.class));
	}
	
	public int deletePerson(int id){
		return jdbcTemplate.update("delete from person where id =?",new Object[]{id});
	}
	
	public int insertPerson(Person p){
		return jdbcTemplate.update("insert into person(id,name,location,birthdate) values(?,?,?,?)",
				new Object[]{p.getId(),p.getName(),p.getLocation(),p.getBirthdate()});
	}
	
	public int updatePerson(Person p){
		return jdbcTemplate.update("update person set name=?,location = ?,birthdate = ? where id =?",
				new Object[]{p.getName(),p.getLocation(),p.getBirthdate(),p.getId()});
	}
}
