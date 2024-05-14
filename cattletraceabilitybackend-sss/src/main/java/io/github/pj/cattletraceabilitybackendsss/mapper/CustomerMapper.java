package io.github.pj.cattletraceabilitybackendsss.mapper;

import io.github.pj.cattletraceabilitybackendsss.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {

    Customer findByUsername(@Param("username") String username);

    void insert(Customer customer);

    Customer findById(@Param("id") Integer id);

    void update(Customer customer);
}
/*
CustomerMapper接口定义了以下方法:
findByUsername: 根据用户名查找客户
insert: 插入新客户
findById: 根据ID查找客户
update: 更新客户信息
*/
