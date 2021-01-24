package demo.mapper.manual;

import demo.pojo.DemoTable;

import java.util.List;

public interface DemoTableDiyMapper {

    int insertBatch(List<DemoTable> demoTables);

}