package io.github.pj.cattletraceabilitybackendsss.mapper;


import io.github.pj.cattletraceabilitybackendsss.entity.SaleOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SaleMapper {

    void insertOrder(SaleOrder order);

    SaleOrder getOrderById(@Param("id") Integer id);

    List<SaleOrder> listOrdersByCustomerId(@Param("customerId") Integer customerId);

    void updateOrderStatus(@Param("id") Integer id, @Param("status") String status);
}
