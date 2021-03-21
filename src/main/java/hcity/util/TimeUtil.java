package hcity.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将Date转换为指定日期格式的String
     */
    public static Date string2Date(String timeString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
        return dateFormat.parse(timeString);
    }

    /**
     * 将Date转换为指定日期格式的String
     */
    public static String date2String(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
        return dateFormat.format(date);
    }

    /**
     * 将指定日期格式的String转换为Timestamp
     *
     * //参数timeString的格式必须为："yyyy-MM-dd HH:mm:ss"
     */
    public static Timestamp string2Timestamp(String timeString) {
        return Timestamp.valueOf(timeString);
    }

    /**
     * 将Timestamp转换为指定日期格式的String
     */
    public static String timestamp2String(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat(PATTERN);//定义日期显示格式
        return df.format(timestamp);
    }

    /**
     * 将Long类型时间戳，转换为Date
     */
    public static Date long2Date(long time){
        return new Date(time);
    }

    /**
     * 将Date转换为Timestamp
     */
    public static Date timestamp2Date2(Date date){
        return new Timestamp(date.getTime());
    }
}
