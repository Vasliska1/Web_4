package com.bbtutorials.users.controller;


import com.bbtutorials.users.entity.Point;
import com.bbtutorials.users.service.PointService;
import com.bbtutorials.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Column;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
public class PointController {

    private PointService pointService;

    @Autowired
    public PointController( PointService pointService) {

        this.pointService = pointService;
    }


    @GetMapping(path = "/api/getPoints")
    public ResponseEntity<?> listPoint() {

        List<Point> resource = pointService.getPointData();
        System.out.println(1212);
        System.out.println(resource.toString());
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = "/api/addPoint")
    public ResponseEntity<?> addPoint(@RequestBody Point point) {
        point.setResult(point.check());
        pointService.savePoint(point);
        return ResponseEntity.ok("ok");
    }

}
