package io.github.pj.cattletraceabilitybackendsss.entity;

import lombok.Data;

@Data
public class SaleOrderItem {
    private Integer id;
    private Integer orderId;
    private Integer processId; // 加工信息ID
    private Integer quantity;
    private Double price;
}