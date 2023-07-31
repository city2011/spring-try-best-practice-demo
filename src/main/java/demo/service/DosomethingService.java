package demo.service;

import demo.aspect.LogAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DosomethingService {

    @LogAnnotation
    public void dosomeThing() {
        System.out.println("DoNothing In fact!");
    }
}
