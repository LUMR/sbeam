package com.lumr.sbeam.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类
 * Created by fsweb on 17-5-8.
 */
public class Utils {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
        return dateFormat.parse(str);
    }
}
