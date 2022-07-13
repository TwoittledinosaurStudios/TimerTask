package com.ChangeBUG.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

@Component
public class StartAllJobInit {

    // 项目路径
    public static String SysPath;

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    // 构造函数之后执行
    @PostConstruct
    public void init(){
        logger.error("====> 正在初始化中");
        SysPath = System.getProperty("user.dir") + "\\TimerTask";
        File folder = new File(SysPath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
        logger.error("====> 初始化成功了");
    }

}
