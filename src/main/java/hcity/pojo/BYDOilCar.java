package hcity.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BYDOilCar extends Car{
    private String bydSeries;

    @Override
    void moveForward() {

    }

    @Override
    void moveBackward() {

    }
}
