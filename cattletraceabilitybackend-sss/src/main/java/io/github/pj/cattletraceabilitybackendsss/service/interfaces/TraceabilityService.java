package io.github.pj.cattletraceabilitybackendsss.service.interfaces;

// 服务接口
public interface TraceabilityService {
    void addRecord(TraceabilityRecord record);
    List<TraceabilityRecord> getRecordsByCattleId(String cattleId);
}

