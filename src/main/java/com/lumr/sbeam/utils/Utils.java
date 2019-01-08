package com.lumr.sbeam.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * 工具类
 * Created by fsweb on 17-5-8.
 */
public class Utils {
    private final static FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd hh:MM:ss");

    /**
     * 加密字符串
     */
    public static String sha1(String str) {
        return DigestUtils.sha1Hex(str);
    }

    /**
     * 日期格式化
     * @param str 要格式的日期字符串
     * @return 格式化后的字符串
     * @throws ParseException 格式化错误
     */
    public static Date parseDate(String str) throws ParseException {
        return DATE_FORMAT.parse(str);
    }
}
