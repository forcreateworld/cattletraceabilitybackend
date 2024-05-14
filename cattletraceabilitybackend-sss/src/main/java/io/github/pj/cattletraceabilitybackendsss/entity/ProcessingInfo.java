package io.github.pj.cattletraceabilitybackendsss.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProcessingInfo {
    private Integer id;
    private Integer cattleId;
    private String processDescription;
    private Double weight;
    private LocalDateTime processTime;
    private String productName;
    private Double price;
    private String status;
}