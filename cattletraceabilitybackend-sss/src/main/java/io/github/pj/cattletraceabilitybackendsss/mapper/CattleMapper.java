package io.github.pj.cattletraceabilitybackendsss.mapper;

import io.github.pj.cattletraceabilitybackendsss.entity.Cattle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CattleMapper {

    void insert(Cattle cattle);

    Cattle getCattleById(@Param("id") Integer id);

    void updateSlaughterTime(Cattle cattle);

    List<Cattle> list();

    void deleteById(@Param("id") Integer id);
}
/*

CattleMapper接口定义了以下方法:
insert: 插入新的牛只
getCattleById: 根据ID获取牛只
updateSlaughterTime: 更新牛只的屠宰时间
list: 获取所有牛只列表
deleteById: 根据ID删除牛只
*/

