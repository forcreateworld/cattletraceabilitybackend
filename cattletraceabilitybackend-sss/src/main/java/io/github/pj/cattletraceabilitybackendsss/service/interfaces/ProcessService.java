package io.github.pj.cattletraceabilitybackendsss.service.interfaces;
import io.github.pj.cattletraceabilitybackendsss.entity.ProcessingInfo;

public interface ProcessService {
    void add(ProcessingInfo process);
    ProcessingInfo getByCalttleId(Integer cattleId);
    void update(ProcessingInfo process);
    void deleteByCalttleId(Integer cattleId);
}