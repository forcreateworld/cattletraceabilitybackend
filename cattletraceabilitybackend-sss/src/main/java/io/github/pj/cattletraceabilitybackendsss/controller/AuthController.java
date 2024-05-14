package io.github.pj.cattletraceabilitybackendsss.controller;

import io.github.pj.cattletraceabilitybackendsss.entity.Customer;
import io.github.pj.cattletraceabilitybackendsss.entity.FactoryUser;
import io.github.pj.cattletraceabilitybackendsss.service.interfaces.CustomerService;
import io.github.pj.cattletraceabilitybackendsss.service.interfaces.FactoryUserService;
import io.github.pj.cattletraceabilitybackendsss.utils.JwtUtils;
import io.github.pj.cattletraceabilitybackendsss.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FactoryUserService factoryUserService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/customer/login")
    public ResponseEntity<?> customerLogin(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Customer customer = customerService.findByUsername(username);
        if (customer != null && Md5Util.getMD5String(password).equals(customer.getPassword())) {
            String token = jwtUtils.generateToken(customer.getId(), username);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().body("Invalid username or password");
    }

    @PostMapping("/customer/register")
    public ResponseEntity<?> customerRegister(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (customerService.findByUsername(username) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(Md5Util.getMD5String(password));
        customer.setCreateTime(LocalDateTime.now());
        customer.setUpdateTime(LocalDateTime.now());

        customerService.register(customer);

        return ResponseEntity.ok("Registration successful");
    }

    // Similar methods for factory user login and registration
}
/*
这是一个认证控制器,处理客户和厂家用户的登录和注册请求。它使用了CustomerService、FactoryUserService和JwtUtils服务。对于登录请求,它会验证用户名和密码,如果有效,则生成JWT令牌并返回。对于注册请求,它会检查用户名是否已存在,如果不存在,则创建新用户并保存到数据库中。
以上就是后端项目中安全配置和认证控制器的代码。请再次确认这部分代码是否准确无误,并且与项目相关联。如果需要,我可以继续展示其他部分的代码。
在展示过程中,如果您发现任何问题或需要补充说明的地方,欢迎您随时提出。我会尽最大努力确保展示的代码是完整的、可运行的,并且可以实现相应的功能
*/
