package io.github.pj.cattletraceabilitybackendsss.controller;
// 控制器类,处理溯源记录相关请求

@RestController
@RequestMapping("/traceability")
public class TraceabilityController {

    @Autowired
    private TraceabilityService traceabilityService;

    @PostMapping
    public Result addRecord(@RequestBody TraceabilityRecord record) {
        traceabilityService.addRecord(record);
        return Result.success();
    }

    @GetMapping
    public Result getRecords(@RequestParam String cattleId) {
        List<TraceabilityRecord> records = traceabilityService.getRecordsByCattleId(cattleId);
        return Result.success(records);
    }
}
`
