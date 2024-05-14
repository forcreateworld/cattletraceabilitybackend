package io.github.pj.cattletraceabilitybackendsss.mapper;

import io.github.pj.cattletraceabilitybackendsss.entity.ProcessingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProcessMapper {

    void insert(ProcessingInfo process);

    ProcessingInfo getByCalttleId(@Param("cattleId") Integer cattleId);

    void update(ProcessingInfo process);

    void deleteByCalttleId(@Param("cattleId") Integer cattleId);
}
/*

ProcessMapper接口定义了以下方法:
insert: 插入新的加工信息
getByCalttleId: 根据牛只ID获取加工信息
update: 更新加工信息
deleteByCalttleId: 根据牛只ID删除加工信息*/
