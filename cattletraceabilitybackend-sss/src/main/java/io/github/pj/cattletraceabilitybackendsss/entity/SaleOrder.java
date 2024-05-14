package io.github.pj.cattletraceabilitybackendsss.entity;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleOrder {
    private Integer id;
    private Integer customerId;
    private List<SaleOrderItem> items;
    private Double totalAmount;
    private String status;
    private LocalDateTime createTime;
}