package io.github.pj.cattletraceabilitybackendsss.controller;

import io.github.pj.cattletraceabilitybackendsss.entity.Customer;
import io.github.pj.cattletraceabilitybackendsss.service.interfaces.CustomerService;
import io.github.pj.cattletraceabilitybackendsss.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CustomerRegisterRequest request) {
        customerService.register(request.getUsername(), request.getPassword());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerLoginRequest request) {
        Customer customer = customerService.findByUsername(request.getUsername());
        if (customer == null || !new BCryptPasswordEncoder().matches(request.getPassword(), customer.getPassword())) {
            return ResponseEntity.badRequest().body("用户名或密码错误");
        }
        String token = jwtUtils.generateToken(customer.getId(), customer.getUsername());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getCustomerInfo(@RequestHeader("Authorization") String token) {
        Integer customerId = jwtUtils.getUserIdFromToken(token);
        Customer customer = customerService.findById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/info")
    public ResponseEntity<?> updateCustomerInfo(@RequestHeader("Authorization") String token,
                                                @RequestBody CustomerUpdateRequest request) {
        Integer customerId = jwtUtils.getUserIdFromToken(token);
        customerService.updateCustomer(customerId, request);
        return ResponseEntity.ok().build();
    }
}
/*CustomerController包含以下几个方法:
register: 处理客户注册请求,调用customerService的register方法
login: 处理客户登录请求,验证用户名和密码,如果正确则生成JWT令牌并返回
getCustomerInfo: 获取当前登录客户的信息,根据JWT令牌中的用户ID调用customerService的findById方法
updateCustomerInfo: 更新当前登录客户的信息,根据JWT令牌中的用户ID调用
        customerService的updateCustomer方法*/
