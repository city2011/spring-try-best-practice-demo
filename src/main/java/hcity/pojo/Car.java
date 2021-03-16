package hcity.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public abstract class Car extends Vehicle{
    protected int wheelNum;
    protected int seatNum;
    protected String engineType;
    protected List<String> accessories;
}
