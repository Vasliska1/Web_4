package com.bbtutorials.users.service;

import com.bbtutorials.users.entity.Point;
import com.bbtutorials.users.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PointService {

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> getPointData() {
        return pointRepository.findAll();
    }

    public Point savePoint(Point point) {
        return pointRepository.save(point);
    }


}
