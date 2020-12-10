package com.bbtutorials.users.controller;

import com.bbtutorials.users.entity.User;
import com.bbtutorials.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private static final String VIEWS_MAIN_SCREEN = "point/main";


    @PostMapping("api/registration")
    public ResponseEntity<String> addUser(@RequestBody User user) {

        Boolean check = userService.saveUser(user);

        if (!check) {
            return ResponseEntity.badRequest()
                    .body("Пользователь с таким именем уже существует");
        } else {
            return ResponseEntity.ok("ok");
        }
    }


    @PostMapping("api/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        if (!userService.checkUser(user)) {
            return ResponseEntity.badRequest()
                    .body("Пользователь с таким именем не найден");
        } else if (!userService.checkPassword(user))
            return ResponseEntity.badRequest()
                    .body("Неверный пароль");
        else return ResponseEntity.ok("ok");

    }


}
