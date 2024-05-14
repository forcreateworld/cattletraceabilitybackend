package io.github.pj.cattletraceabilitybackendsss.service.interfaces;
import io.github.pj.cattletraceabilitybackendsss.entity.Customer;

//CustomerService接口
public interface CustomerService {
    Customer findByUsername(String username);
    void register(String username, String password);
    Customer findById(Integer id);
    void updateCustomer(Integer id, CustomerUpdateRequest request);
}