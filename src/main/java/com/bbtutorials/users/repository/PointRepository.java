package com.bbtutorials.users.repository;

import com.bbtutorials.users.entity.Point;
import com.bbtutorials.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PointRepository extends JpaRepository<Point, Long> {
    List<Point> getAllByUser(User user);
}
