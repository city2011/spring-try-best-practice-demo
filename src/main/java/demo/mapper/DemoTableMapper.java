package demo.mapper;

import demo.pojo.DemoTable;
import demo.pojo.DemoTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoTableMapper {
    int countByExample(DemoTableExample example);

    int deleteByExample(DemoTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DemoTable record);

    int insertSelective(DemoTable record);

    List<DemoTable> selectByExample(DemoTableExample example);

    DemoTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoTable record, @Param("example") DemoTableExample example);

    int updateByExample(@Param("record") DemoTable record, @Param("example") DemoTableExample example);

    int updateByPrimaryKeySelective(DemoTable record);

    int updateByPrimaryKey(DemoTable record);

}