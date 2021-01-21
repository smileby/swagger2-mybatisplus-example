package com.baiyun.controller;

import com.baiyun.model.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api("testController测试")
@RequestMapping("swaggerController")
public class SwaggerController {


    /**
     * @ApiOperation：用在请求的方法上，说明方法的用途、作用
     *      value="说明方法的用途、作用"
     *      notes="方法的备注说明"
     * ApiImplicitParams
     *      name：参数名
     *      value ： 参数描述
     *      required ： 是否必填
     *      dataType : 参数类型
     *      paramType ： 参数传入方式：
     *          header-->放在请求头。请求参数的获取：@RequestHeader(代码中接收注解)
                query-->用于get请求的参数拼接。请求参数的获取：@RequestParam(代码中接收注解)
                path（用于restful接口）-->请求参数的获取：@PathVariable(代码中接收注解)
                body-->放在请求体。请求参数的获取：@RequestBody(代码中接收注解)
                form（不常用）
            defaultValue： 参数默认值


     * @param param
     * @param param1
     * @return
     */
    @ApiOperation(value="getOne", notes = "getOne方法")
    @ApiImplicitParams({@ApiImplicitParam (name = "param" ,value = "getOne方法入参1" ,required = true,dataType="String",paramType = "path"),
            @ApiImplicitParam (name = "param1" ,value = "getOne方法入参2" ,required = true,dataType="String",paramType = "path")
    })
    @GetMapping("getOne/{param}/{param1}")
    @ResponseBody
    public String getOne(@PathVariable("param")String param, @PathVariable("param1")String param1){
        return param;
    }

    @ApiOperation(value = "getTwo", notes = "getTwo方法")
    @ApiImplicitParam(name = "person", value = "getTwo方法入参", required = true, dataType = "Person", paramType = "body")
    @PostMapping("getTwo")
    @ResponseBody
    public Person getTwo(@RequestBody Person person){
        return person;
    }
}
