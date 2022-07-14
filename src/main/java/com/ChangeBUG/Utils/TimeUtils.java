package com.ChangeBUG.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class TimeUtils {

    Logger logger = LoggerFactory.getLogger(getClass().getName());


    /**
     * 获取当前时间返回字符串
     *
     * @return
     */
    public String GetDangTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(date);
    }

}