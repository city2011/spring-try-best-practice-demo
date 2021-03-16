package hcity.service;

import com.google.common.collect.Lists;
import hcity.pojo.BYDOilCar;
import hcity.pojo.Vehicle;
import hcity.pojo.Zoo;
import hcity.util.FastJsonUtil;
import hcity.util.GsonUtil;
import org.apache.commons.lang.StringEscapeUtils;

public class JsonMainTest {
    public static void main(String[] args) {
        JsonMainTest m = new JsonMainTest();
        m.testZooJson();
        m.testJson();
    }

    private void testZooJson(){
        Zoo zoo = new Zoo();
        Zoo.Dog dog = new Zoo.Dog();
        dog.setName("whiteTornado");
        zoo.setDogs(Lists.newArrayList(dog));
        zoo.setIsOpen(true);
        zoo.setName("Jurassic Park");

        String zooGson = GsonUtil.serialize(zoo);
        System.out.println("zooGson escapeJava");
        System.out.println(StringEscapeUtils.escapeJava(zooGson)  + "\n\n");
        System.out.println(zooGson + "\n\n");

        String zooFast = FastJsonUtil.serialize(zoo);
        System.out.println("zooFast");
        System.out.println(zooFast + "\n\n");

        String zooFastComplete = FastJsonUtil.serializeWithNulls(zoo);
        System.out.println("zooFastComplete");
        System.out.println(zooFastComplete);

    }

    private void testJson(){
        Vehicle bydOilCar = new BYDOilCar();
        bydOilCar.setPrice(1000000L);

        String bydOilCarG = GsonUtil.serialize(bydOilCar);
        System.out.println(bydOilCarG);

        String bydOilCarF = FastJsonUtil.serialize(bydOilCar);
        System.out.println(bydOilCarF);

        String bydOilCarFN = FastJsonUtil.serializeWithNulls(bydOilCar);
        System.out.println(bydOilCarFN);
    }
}
