package io.github.pj.cattletraceabilitybackendsss.mapper;

// 数据库映射器
@Mapper
public interface TraceabilityMapper {

    @Insert("INSERT INTO traceability (cattle_id, location, description, timestamp) " +
            "VALUES (#{cattleId}, #{location}, #{description}, #{timestamp})")
    void insert(TraceabilityRecord record);

    @Select("SELECT * FROM traceability WHERE cattle_id = #{cattleId}")
    List<TraceabilityRecord> selectByCattleId(String cattleId);
}
