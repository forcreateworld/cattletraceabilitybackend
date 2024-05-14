package io.github.pj.cattletraceabilitybackendsss.entity;

import lombok.Data;

@Data
public class FactoryUser {
    private Integer id;
    private String username;
    private String password;
    private String factoryName;
    private String factoryAddress;
}
