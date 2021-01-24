package demo.mapper.manual;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DemoTableAnnotateMapper {

    @Update({
            "<script>",
            "update demo_table set update_time = CURRENT_TIMESTAMP where id in (",
            "<foreach collection = 'list' item = 'item' separator = ','>",
            "#{item}",
            "</foreach>",
            ")",
            "</script>"
    })
    int updateBatch(List<Integer> ids);
}
