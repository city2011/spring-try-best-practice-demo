package hcity.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Vehicle {
    protected long price;
    protected Double weight;
    protected Double height;
    protected Double length;
    protected Double width;

    abstract void moveForward();
    abstract void moveBackward();
}
