package io.github.pj.cattletraceabilitybackendsss.service.interfaces;

import io.github.pj.cattletraceabilitybackend.entity.FactoryUser;

public interface FactoryUserService {
    FactoryUser findByUsername(String username);
    void register(String username, String password, String factoryName, String factoryAddress);
    FactoryUser findById(Integer id);
    void updateFactoryUser(Integer id, FactoryUserUpdateRequest request);
}
/*
actoryUserService接口定义了以下方法:
findByUsername: 根据用户名查找厂家用户
register: 厂家用户注册
findById: 根据ID查找厂家用户
updateFactoryUser: 更新厂家用户信息*/
