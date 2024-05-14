package io.github.pj.cattletraceabilitybackendsss.controller;

import io.github.pj.cattletraceabilitybackend.entity.SaleOrder;
import io.github.pj.cattletraceabilitybackend.service.interfaces.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody SaleOrder order) {
        saleService.createOrder(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOrderDetails(@PathVariable Integer id) {
        SaleOrder order = saleService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getOrderList(@RequestHeader("customerId") Integer customerId) {
        List<SaleOrder> orders = saleService.listOrdersByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/order/{id}/status")
    public ResponseEntity<?> updateOrderStatus(@PathVariable Integer id, @RequestBody String status) {
        saleService.updateOrderStatus(id, status);
        return ResponseEntity.ok().build();
    }
}
//`SaleController包含了创建销售订单、获取订单详情、获取客户订单列表和更新订单状态等方法。