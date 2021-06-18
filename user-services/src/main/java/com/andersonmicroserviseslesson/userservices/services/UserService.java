package com.andersonmicroserviseslesson.userservices.services;

import com.andersonmicroserviseslesson.userservices.VO.Department;
import com.andersonmicroserviseslesson.userservices.VO.ResponseTemplateVO;
import com.andersonmicroserviseslesson.userservices.controller.UserController;
import com.andersonmicroserviseslesson.userservices.entity.User;
import com.andersonmicroserviseslesson.userservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private UserRepository userRepository;
    private RestTemplate restTemplate;
    private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("WE ARE IN GET USER WITH DEPARTMENT SERVICE!!!");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
