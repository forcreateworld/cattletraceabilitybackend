package io.github.pj.cattletraceabilitybackendsss.service.Impl;

import io.github.pj.cattletraceabilitybackendsss.entity.ProcessingInfo;
import io.github.pj.cattletraceabilitybackendsss.mapper.ProcessMapper;
import io.github.pj.cattletraceabilitybackendsss.service.interfaces.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper processMapper;

    @Override
    public void add(ProcessingInfo process) {
        process.setProcessTime(LocalDateTime.now());
        processMapper.insert(process);
    }

    @Override
    public ProcessingInfo getByCalttleId(Integer cattleId) {
        return processMapper.getByCalttleId(cattleId);
    }

    @Override
    public void update(ProcessingInfo process) {
        processMapper.update(process);
    }

    @Override
    public void deleteByCalttleId(Integer cattleId) {
        processMapper.deleteByCalttleId(cattleId);
    }
}
//ProcessServiceImpl实现类实现了ProcessService接口中定义的方法,包括添加新加工信息、根据牛只ID获取加工信息、更新加工信息和根据牛只ID删除加工信息等。