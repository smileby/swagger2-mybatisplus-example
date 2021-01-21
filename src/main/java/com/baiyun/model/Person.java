package com.baiyun.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "Person", description = "人员信息")
@Data
public class Person implements Serializable{

    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private int age;
    @ApiModelProperty("性别")
    private String sex;

}
