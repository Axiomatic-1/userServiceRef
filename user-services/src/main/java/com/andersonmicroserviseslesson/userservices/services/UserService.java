package com.andersonmicroserviseslesson.userservices.services;

import com.andersonmicroserviseslesson.userservices.VO.Plate;
import com.andersonmicroserviseslesson.userservices.VO.ResponseTemplateVO;
import com.andersonmicroserviseslesson.userservices.entity.User;
import com.andersonmicroserviseslesson.userservices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    private UserRepository userRepository;
    private RestTemplate restTemplate;


    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithPlate(Long userId) {
        log.info("WE ARE IN GET USER WITH DEPARTMENT SERVICE!!!");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Plate plate =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getPlateId()
                        , Plate.class);
        vo.setUser(user);
        vo.setPlate(plate);
        return vo;
    }
}
