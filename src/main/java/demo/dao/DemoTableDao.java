package demo.dao;

import demo.mapper.DemoTableMapper;
import demo.mapper.manual.DemoTableAnnotateMapper;
import demo.mapper.manual.DemoTableDiyMapper;
import demo.pojo.DemoTable;
import demo.pojo.DemoTableExample;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
public class DemoTableDao {
    @Resource
    DemoTableMapper mapper;
    @Resource
    DemoTableAnnotateMapper annotateMapper;
    @Resource
    DemoTableDiyMapper diyMapper;

    public List<DemoTable> selectByRule(Date date){
        DemoTableExample example = new DemoTableExample();
        example.createCriteria().andCreateTimeLessThan(date);
        return mapper.selectByExample(example);
    }

    public int insert(DemoTable demoTable){
        DemoTable table = new DemoTable();
        table.setDemoName("huang");
        return mapper.insert(demoTable);
    }

    public int insertSelective(DemoTable demoTable){
        DemoTable table = new DemoTable();
        table.setDemoName("huang");
        return mapper.insertSelective(demoTable);
    }

    public int updateByPrimaryKeySelective(DemoTable demoTable){
        return mapper.updateByPrimaryKeySelective(demoTable);
    }

    public int updateByRule(DemoTable demoTable){
        return mapper.updateByPrimaryKeySelective(demoTable);
    }

    public int updateBatch(List<Integer> ids){
        return annotateMapper.updateBatch(ids);
    }

    public int insertBatch(List<DemoTable> demoTables){
        if(CollectionUtils.isEmpty(demoTables)){
            return -1;
        }
        return diyMapper.insertBatch(demoTables);
    }
}
