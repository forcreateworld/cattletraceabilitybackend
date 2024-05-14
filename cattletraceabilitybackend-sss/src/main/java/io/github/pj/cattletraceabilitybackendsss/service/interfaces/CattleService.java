package io.github.pj.cattletraceabilitybackendsss.service.interfaces;

import io.github.pj.cattletraceabilitybackendsss.entity.Cattle;
import java.util.List;

public interface CattleService {
    void add(Cattle cattle);
    Cattle getCattleById(Integer id);
    void updateSlaughterTime(Cattle cattle);
    List<Cattle> list();
    void delete(Integer id);
}
/*
add: 添加新的牛只
getCattleById: 根据ID获取牛只
updateSlaughterTime: 更新牛只的屠宰时间
list: 获取所有牛只列表
delete: 删除指定ID的牛只*/
