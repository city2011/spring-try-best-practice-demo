package demo;

import demo.service.DosomethingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTest {
    @Resource
    private DosomethingService dosomethingService;

    @Test
    public void testDosomething(){
        dosomethingService.dosomeThing();
    }

}
