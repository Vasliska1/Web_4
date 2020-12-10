package com.bbtutorials.users.repository;

import com.bbtutorials.users.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PointRepository extends JpaRepository<Point, Long> {

}
