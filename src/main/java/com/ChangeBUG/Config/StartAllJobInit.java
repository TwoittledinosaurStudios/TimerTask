package com.ChangeBUG.Config;

import com.ChangeBUG.Model.FileTable;
import com.ChangeBUG.Service.FileTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

@Component
public class StartAllJobInit {

    @Autowired
    FileTableService fileTableService;

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    // 系统路径
    public static String SysPath;
    // 系统缓存数据
    public static List<FileTable> fileTableList;


    // 构造函数之后执行
    @PostConstruct
    public void init() {
        logger.error("====> 正在初始化中");
        SysPath = System.getProperty("user.dir") + "\\TimerTask";
        File folder = new File(SysPath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }

        fileTableList = fileTableService.list();

        logger.error("====> 初始化成功了");
    }

}
