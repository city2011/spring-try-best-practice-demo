package hcity.api;

import pojo.TestPostParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inner")
public class InnerTestController {

    @PostMapping("/mapping")
    public void testPostIn(@RequestBody TestPostParam param) {
        System.out.println(param);
    }
}
