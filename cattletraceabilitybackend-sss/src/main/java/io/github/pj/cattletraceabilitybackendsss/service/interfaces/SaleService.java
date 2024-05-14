package io.github.pj.cattletraceabilitybackendsss.service.interfaces;

import io.github.pj.cattletraceabilitybackend.entity.SaleOrder;
import java.util.List;

public interface SaleService {
    void createOrder(SaleOrder order);
    SaleOrder getOrderById(Integer id);
    List<SaleOrder> listOrdersByCustomerId(Integer customerId);
    void updateOrderStatus(Integer id, String status);
}