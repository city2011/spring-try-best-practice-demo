package demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Before("@annotation(LogAnnotation)")
    public void before() {
        System.out.println(String.format("BeforeLogAnn [%s]", 1));

    }

    @After(value = "@annotation(LogAnnotation)")
    public void testAround() {
//        String name = logAnnotation. name();
//        ll.info("@TestAnnotation around msg: [{}]", 2);
        //do something
    }
}