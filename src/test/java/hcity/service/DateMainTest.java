package hcity.service;

import com.google.common.collect.Lists;
import hcity.util.TimeUtil;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class DateMainTest {
    public static void main(String[] args) {
        DateMainTest m = new DateMainTest();
        try {
            m.test1();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> x = Lists.newArrayList("1","@","3");
        List<String> y = x.subList(2,2);
        System.out.println(y);
    }

    private void test1() throws ParseException {
        String fromTime = "2021-03-19 00:00:00";
        String toTime = "2021-03-20 00:00:00";
        Date fromDate = TimeUtil.string2Date(fromTime);
        Date toDate = TimeUtil.string2Date(toTime);
        // 操作记录正式记录的开始时间为1615536000000L。
        if (fromDate.getTime() < 1616169600000L){
            fromDate = Date.from(Instant.ofEpochMilli(1616169600000L));
        }
        System.out.println(TimeUtil.date2String(fromDate));
        System.out.println(fromDate);
        System.out.println(fromDate.toString());
    }
}
