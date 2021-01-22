package demo.dao;

import demo.pojo.DemoTable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTableDaoTest {
    @Resource
    private DemoTableDao dao;

    private DemoTable record;

    @Before
    public void init() {
        record = new DemoTable();
        record.setId(2);
        record.setContentText(getContent());
        record.setDemoName("Name1");
        record.setDemoValue("Demovalue");
    }

    @Test
    public void testInsert() {
        record.setCreateTime(Date.from(Instant.now()));
        record.setUpdateTime(Date.from(Instant.now()));
        // 数据库设置上述两个字段不为空。insert必须要设置值
        dao.insert(record);
        record.setCreateTime(null);
        record.setUpdateTime(null);
    }

    @Test
    public void testInsertSelective() {
        // 下面对主键的设置是不生效的。
        record.setId( 3);
        dao.insertSelective(record);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        String preName = record.getDemoName();
        record.setDemoName("我更新啦");
        dao.updateByPrimaryKeySelective(record);
        record.setDemoName(preName);
    }

    private String getContent(){
        return "这是一首咏史词，借叙述历史兴亡抒发人生感慨，豪放中有含蓄，高亢中有深沉。\n" +
                "从全词看，古今的高士，就更见他淡泊超脱的襟怀，这正是作者所追求的理想人格。在其生活环境、生活情趣中寄托自己的人生理想，从而表现出一种大彻大悟的历史观和人生观。\n" +
                "全词似怀古，似物志。从大处落笔，可以说是以词写的史论，也是以词写的人生论。千古风流人物，无论是非成败，一样在历史的长河中被淘尽，唯有青山绿水永恒存在。词人作为首辅之子、一代状元，然一朝得罪，老死南荒。此篇虚中实，未涉及任何具体的历史事件、人物，却包罗一切，容量极大}";
    }
}