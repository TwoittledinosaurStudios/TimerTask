package com.ChangeBUG.Config;

import com.ChangeBUG.Model.FileTable;
import com.ChangeBUG.Service.FileTableService;
import com.ChangeBUG.Utils.PythonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledTask {

    @Autowired
    FileTableService fileTableService;
    @Autowired
    PythonUtils pythonUtils;

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    // fixedRate    上一次开始执行时间点之后 3 秒再执行 1000 = 1秒
    // fixedDelay   上一次执行完毕时间点之后 3 秒再执行 1000 = 1秒
    //
    // cron 表达式有
    // 0 0 2 1 * ? *                ：表示在每月 1 日的凌晨 2 点执行
    // 0 15 10 ? * MON-FRI          ：表示周一到周五每天上午 10:15 执行
    // 0 15 10 ? 6L 2019-2020       ：表示 2019-2020 年的每个月的最后一个星期五上午 10:15 执行
    // 0 0 10,14,16 * * ?           ：每天上午 10 点，下午 2 点，4 点执行
    // 0 0/30 9-17 * * ?            ：朝九晚五工作时间内每半小时执行
    // 0 0 12 ? * WED               ：表示每个星期三中午 12 点执行
    // 0 0 12 * * ?                 ：每天中午 12点执行
    // 0 15 10 ? * *                ：每天上午 10:15 执行
    // 0 15 10 * * ?                ：每天上午 10:15 执行
    // 0 15 10 * * ? *              ：每天上午 10:15 执行
    // 0 15 10 * * ? 2019 : 2019    ：年的每天上午 10:15 执行
    @Scheduled(fixedDelay = 1000)
    public void scheduledTask() throws Exception {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = dateFormat.format(date);
        if (time.equals("19:17:00")) {
            List<FileTable> list = fileTableService.list();
            for (FileTable fileTable : list) {
                System.out.println(fileTable.getFileName());
                System.out.println(pythonUtils.RunPython(StartAllJobInit.SysPath + fileTable.getFilePath()));
            }
        }

    }

}