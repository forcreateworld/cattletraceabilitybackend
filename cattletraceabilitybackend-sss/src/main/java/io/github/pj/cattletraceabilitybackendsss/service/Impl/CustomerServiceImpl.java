package io.github.pj.cattletraceabilitybackendsss.service.Impl;

import io.github.pj.cattletraceabilitybackendsss.entity.Customer;
import io.github.pj.cattletraceabilitybackendsss.mapper.CustomerMapper;
import io.github.pj.cattletraceabilitybackendsss.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer findByUsername(String username) {
        return customerMapper.findByUsername(username);
    }

    @Override
    public void register(String username, String password) {
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(encodedPassword);
        customerMapper.insert(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerMapper.findById(id);
    }

    @Override
    public void updateCustomer(Integer id, CustomerUpdateRequest request) {
        Customer customer = customerMapper.findById(id);
        customer.setNickname(request.getNickname());
        customer.setEmail(request.getEmail());
        customer.setUserPic(request.getUserPic());
        customerMapper.update(customer);
    }
}
/*
这个CustomerServiceImpl实现类实现了CustomerService接口中定义的方法:
findByUsername: 直接调用customerMapper的findByUsername方法查找客户
register: 首先对密码进行BCrypt加密,然后创建Customer对象并调用customerMapper的insert方法插入新客户
findById: 直接调用customerMapper的findById方法根据ID查找客户
updateCustomer: 首先根据ID查找客户,然后更新客户的昵称、邮箱和头像,最后调用customerMapper的update方法更新客户信息*/
