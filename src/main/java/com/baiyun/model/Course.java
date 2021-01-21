package com.baiyun.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable{

    private String cno;

    private String cname;

    private String credit;

    private String semester;

}
