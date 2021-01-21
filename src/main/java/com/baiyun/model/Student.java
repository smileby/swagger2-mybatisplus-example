package com.baiyun.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("student")
public class Student implements Serializable{
    @TableId("sno")
    private String sno;
    @TableField("sname")
    private String sname;
    @TableField("ssex")
    private String ssex;
    @TableField("sage")
    private String sage;
    @TableField("dept")
    private String dept;
}
