package com.in28minutes.database.databasedemo;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jpa.PersonJpaDao;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	@Autowired
	PersonJdbcDao dao;
	
	//@Autowired
	//PersonJpaDao dao;
	
	private Logger log =  LoggerFactory.getLogger(this.getClass());
	 
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("get res --> {}",dao.findAll());
		log.info("get id 10002 --> {}",dao.findById(10001));
		log.info("delete 10002 --> {}",dao.deletePerson(10002));
		log.info("get id 10003 --> {}",dao.updatePerson(new Person(101,"rohu656 6 3","loc 36656",new Date(System.currentTimeMillis()))));
		//log.info("get res --> {}",dao.findById(10001));
	}

}

