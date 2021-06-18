package com.andersonmicroserviseslesson.userservices.controller;

import com.andersonmicroserviseslesson.userservices.VO.ResponseTemplateVO;
import com.andersonmicroserviseslesson.userservices.entity.User;
import com.andersonmicroserviseslesson.userservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("We are saved user :" + user.toString());
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long UserId){
        log.info("We are in getUserWithDepartment method");
        return userService.getUserWithDepartment(UserId);
    }
}
