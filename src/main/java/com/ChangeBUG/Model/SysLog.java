package com.ChangeBUG.Model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_log")
public class SysLog {
    /**
     * 日志
     */
    @TableField(value = "log_log")
    private String logLog;

    /**
     * 日志存入时间
     */
    @TableField(value = "log_time")
    private Date logTime;
}