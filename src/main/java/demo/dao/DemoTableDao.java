package demo.dao;

import demo.mapper.DemoTableMapper;
import demo.pojo.DemoTable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class DemoTableDao {
    @Resource
    DemoTableMapper mapper;

    public int insert(DemoTable demoTable){
        return mapper.insert(demoTable);
    }

    public int insertSelective(DemoTable demoTable){
        return mapper.insertSelective(demoTable);
    }

    public int updateByPrimaryKeySelective(DemoTable demoTable){
        return mapper.updateByPrimaryKeySelective(demoTable);
    }
}
