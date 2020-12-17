package com.bbtutorials.users.controller;


import com.bbtutorials.users.entity.Point;
import com.bbtutorials.users.service.PointService;
import com.bbtutorials.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Controller
public class PointController {
    private final UserService userService;
    private PointService pointService;

    @Autowired
    public PointController(PointService pointService, UserService userService) {
        this.userService = userService;
        this.pointService = pointService;
    }


    @GetMapping(path = "/api/point")
    public ResponseEntity<?> listPoint(Principal user) {

        List<Point> resource = pointService.getPointsByUsername(userService.findByUsername(user.getName()));
        return ResponseEntity.ok(resource);

    }

    @PostMapping(path = "/api/point")
    public ResponseEntity<?> addPoint(@RequestBody Point point, Principal user) {

        point.setResult(point.check());
        System.out.println(user.getName());
        point.setUser(userService.findByUsername(user.getName()));
        pointService.savePoint(point);
        return ResponseEntity.ok(point);
    }

}
