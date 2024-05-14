package io.github.pj.cattletraceabilitybackendsss.service.Impl;

import io.github.pj.cattletraceabilitybackend.entity.FactoryUser;
import io.github.pj.cattletraceabilitybackend.mapper.FactoryUserMapper;
import io.github.pj.cattletraceabilitybackend.service.interfaces.FactoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FactoryUserServiceImpl implements FactoryUserService {

    @Autowired
    private FactoryUserMapper factoryUserMapper;

    @Override
    public FactoryUser findByUsername(String username) {
        return factoryUserMapper.findByUsername(username);
    }

    @Override
    public void register(String username, String password, String factoryName, String factoryAddress) {
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        FactoryUser user = new FactoryUser();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setFactoryName(factoryName);
        user.setFactoryAddress(factoryAddress);
        factoryUserMapper.insert(user);
    }

    @Override
    public FactoryUser findById(Integer id) {
        return factoryUserMapper.findById(id);
    }

    @Override
    public void updateFactoryUser(Integer id, FactoryUserUpdateRequest request) {
        FactoryUser user = factoryUserMapper.findById(id);
        user.setFactoryName(request.getFactoryName());
        user.setFactoryAddress(request.getFactoryAddress());
        factoryUserMapper.update(user);
    }
}