package com.bbtutorials.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
/*

spring.datasource.url=jdbc:h2:mem:testdb
		spring.datasource.driverClassName=org.h2.Driver
		spring.datasource.username=sa
		spring.datasource.password=password
		spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

		spring.h2.console.enabled=true
*/
