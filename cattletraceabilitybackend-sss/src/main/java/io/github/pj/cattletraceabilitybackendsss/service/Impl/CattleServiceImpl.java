package io.github.pj.cattletraceabilitybackendsss.service.Impl;

import io.github.pj.cattletraceabilitybackendsss.entity.Cattle;
import io.github.pj.cattletraceabilitybackendsss.mapper.CattleMapper;
import io.github.pj.cattletraceabilitybackendsss.service.interfaces.CattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CattleServiceImpl implements CattleService {

    @Autowired
    private CattleMapper cattleMapper;

    @Override
    public void add(Cattle cattle) {
        cattleMapper.insert(cattle);
    }

    @Override
    public Cattle getCattleById(Integer id) {
        return cattleMapper.getCattleById(id);
    }

    @Override
    public void updateSlaughterTime(Cattle cattle) {
        cattleMapper.updateSlaughterTime(cattle);
    }

    @Override
    public List<Cattle> list() {
        return cattleMapper.list();
    }

    @Override
    public void delete(Integer id) {
        cattleMapper.deleteById(id);
    }
}
/*
CattleServiceImpl实现类实现了CattleService接口中定义的方法,包括添加新牛只、根据ID获取牛只
、更新屠宰时间、获取牛只列表和删除牛只等。
*/
