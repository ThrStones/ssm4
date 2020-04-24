package com.galaxy.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            System.out.println("字符串转换成日期");
            date = format.parse(str);
        } catch (ParseException e) {
            System.out.println("转换失败，请按照格式输入");
            e.printStackTrace();
        }
        return date;
    }
}
