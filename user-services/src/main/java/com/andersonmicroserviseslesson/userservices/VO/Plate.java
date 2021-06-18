package com.andersonmicroserviseslesson.userservices.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plate {
    private Long plateId;
    private String plateName;
    private String adress;
    private String departmentCode;

}
