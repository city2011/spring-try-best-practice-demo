package hcity.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Zoo {
    private List<Dog> dogs;
    private List<Camel> camels;
    private String name;
    private Long peopleNums;
    private Boolean isOpen;
    private String city;

    @Getter
    @Setter
    @ToString
    public static class Dog{
        private String name;
    }

    @Getter
    @Setter
    @ToString
    public static class Camel{
        private String name;
        private Integer HumpNum;
    }
}
