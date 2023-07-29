package pojo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
public class TestPostParam {

    private Map<String, String> mapA = new HashMap<>();
    private double mp = 1.0;
}
