package io.github.pj.cattletraceabilitybackendsss.service.Impl;

// 服务实现类
@Service
public class TraceabilityServiceImpl implements TraceabilityService {

    @Autowired
    private TraceabilityMapper traceabilityMapper;

    @Override
    public void addRecord(TraceabilityRecord record) {
        traceabilityMapper.insert(record);
    }

    @Override
    public List<TraceabilityRecord> getRecordsByCattleId(String cattleId) {
        return traceabilityMapper.selectByCattleId(cattleId);
    }
}
