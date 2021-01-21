package com.baiyun.controller;

import com.baiyun.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api("Test for MybatisPlus service")
@RequestMapping("service-plus")
public class MbpServiceController {

    @Autowired
    private StudentService studentServic;

    public void list1(){
//        List list = studentServic.list();
    }
}
