package io.github.pj.cattletraceabilitybackendsss.controller;

import io.github.pj.cattletraceabilitybackend.entity.FactoryUser;
import io.github.pj.cattletraceabilitybackend.service.interfaces.FactoryUserService;
import io.github.pj.cattletraceabilitybackend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factory")
public class FactoryUserController {

    @Autowired
    private FactoryUserService factoryUserService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody FactoryUserRegisterRequest request) {
        factoryUserService.register(request.getUsername(), request.getPassword(), request.getFactoryName(), request.getFactoryAddress());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody FactoryUserLoginRequest request) {
        FactoryUser user = factoryUserService.findByUsername(request.getUsername());
        if (user == null || !new BCryptPasswordEncoder().matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body("用户名或密码错误");
        }
        String token = jwtUtils.generateToken(user.getId(), user.getUsername());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getFactoryUserInfo(@RequestHeader("Authorization") String token) {
        Integer userId = jwtUtils.getUserIdFromToken(token);
        FactoryUser user = factoryUserService.findById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/info")
    public ResponseEntity<?> updateFactoryUserInfo(@RequestHeader("Authorization") String token,
                                                   @RequestBody FactoryUserUpdateRequest request) {
        Integer userId = jwtUtils.getUserIdFromToken(token);
        factoryUserService.updateFactoryUser(userId, request);
        return ResponseEntity.ok().build();
    }
}
/*
FactoryUserController包含以下几个方法:
register: 处理厂家用户注册请求,调用factoryUserService的register方法
login: 处理厂家用户登录请求,验证用户名和密码,如果正确则生成JWT令牌并返回
getFactoryUserInfo: 获取当前登录厂家用户的信息,根据JWT令牌中的用户ID调用factoryUserService的findById方法
updateFactoryUserInfo: 更新当前登录厂家用户的信息,根据JWT令牌中的用户ID调用factoryUserService的updateFactoryUser方法*/
