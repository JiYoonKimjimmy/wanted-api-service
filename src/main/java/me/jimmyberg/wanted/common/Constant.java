package me.jimmyberg.wanted.common;

import java.time.format.DateTimeFormatter;

public class Constant {

    public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public static DateTimeFormatter DATE_TIME_FORMAT_yyyyMMddHHmmss = DateTimeFormatter.ofPattern(Constant.yyyyMMddHHmmss);

}
