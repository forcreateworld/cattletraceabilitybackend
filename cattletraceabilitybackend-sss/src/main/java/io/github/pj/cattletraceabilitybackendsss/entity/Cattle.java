package io.github.pj.cattletraceabilitybackendsss.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Cattle {
    private Integer id;
    private String cattleName;
    private String breed;
    private String breedPictures;
    private Double weight;
    private LocalDate birthDate;
    private LocalDate quarantineDate;
    private String growthCycle;
    private LocalDateTime slaughterTime;
    private Integer processStatus;
    private LocalDateTime createTime;
}
//Cattle实体类定义了牛只的基本属性,包括id、牛只名称、品种、品种图片、体重、出生日期、检疫日期、生长周期、屠宰时间、加工状态和创建时间。