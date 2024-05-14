package io.github.pj.cattletraceabilitybackendsss.mapper;

import io.github.pj.cattletraceabilitybackendsss.entity.FactoryUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FactoryUserMapper {

    FactoryUser findByUsername(@Param("username") String username);

    void insert(FactoryUser user);

    FactoryUser findById(@Param("id") Integer id);

    void update(FactoryUser user);
}