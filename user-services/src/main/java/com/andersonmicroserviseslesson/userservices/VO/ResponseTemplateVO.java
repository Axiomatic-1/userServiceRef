package com.andersonmicroserviseslesson.userservices.VO;

import com.andersonmicroserviseslesson.userservices.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private User user;
    private Plate plate;
}
