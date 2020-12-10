package com.bbtutorials.users.repository;


import com.bbtutorials.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(@Param("username") String username);

}
