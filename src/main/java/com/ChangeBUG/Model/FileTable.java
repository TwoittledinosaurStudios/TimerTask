package com.ChangeBUG.Model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件记录信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "file_table")
public class FileTable {
    /**
     * 编号和执行序号
     */
    @TableId(value = "file_id", type = IdType.INPUT)
    private Integer fileId;

    /**
     * 名称
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * 执行路径
     */
    @TableField(value = "file_path")
    private String filePath;

    /**
     * 执行附带参数
     */
    @TableField(value = "file_parameter")
    private String fileParameter;
}