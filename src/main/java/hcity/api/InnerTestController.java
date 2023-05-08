package hcity.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcity.pojo.TestPostParam;

@RestController
@RequestMapping("/inner")
public class InnerTestController {

    @PostMapping("/mapping")
    public void testPostIn(@RequestBody TestPostParam param) {
        System.out.println(param);
    }
}
