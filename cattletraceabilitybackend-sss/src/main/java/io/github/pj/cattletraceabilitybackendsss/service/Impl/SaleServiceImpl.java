package io.github.pj.cattletraceabilitybackendsss.service.Impl;

import io.github.pj.cattletraceabilitybackend.entity.SaleOrder;
import io.github.pj.cattletraceabilitybackend.mapper.SaleMapper;
import io.github.pj.cattletraceabilitybackend.service.interfaces.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public void createOrder(SaleOrder order) {
        saleMapper.insertOrder(order);
    }

    @Override
    public SaleOrder getOrderById(Integer id) {
        return saleMapper.getOrderById(id);
    }

    @Override
    public List<SaleOrder> listOrdersByCustomerId(Integer customerId) {
        return saleMapper.listOrdersByCustomerId(customerId);
    }

    @Override
    public void updateOrderStatus(Integer id, String status) {
        saleMapper.updateOrderStatus(id, status);
    }
}
