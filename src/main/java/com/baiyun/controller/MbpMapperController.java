package com.baiyun.controller;

import com.baiyun.mapper.StudentMapper;
import com.baiyun.model.Student;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api("Test for MybatisPlus mapper")
@RequestMapping("mapper-plus")
public class MbpMapperController {

    @Autowired
    private StudentMapper studentMapper;



    @ResponseBody
    @RequestMapping("selectById")
    public Student selectById(){
        Student student = studentMapper.selectById("0811101");
        return student;
    }

    @ResponseBody
    @RequestMapping("selectBatchIds")
    public List<Student> selectBatchIds(){
        List<String> strings = Arrays.asList("0811101", "0811102", "0811103");
        return studentMapper.selectBatchIds(strings);
    }

    @ResponseBody
    @RequestMapping("selectOne")
    public Student selectOne(){
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<Student>();
        wrapper.eq(Student::getSno, "0811101");
        return studentMapper.selectOne(wrapper);
    }

    @ResponseBody
    @RequestMapping("selectByMap")
    public List<Student> selectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("sno", "0811102");
        List<Student> students = studentMapper.selectByMap(map);
        return students;
    }

    @ResponseBody
    @RequestMapping("selectMapsPage/{pageNo}")
    public IPage<Map<String, Object>> selectMapsPage(@PathVariable Integer pageNo){
        IPage<Map<String, Object>> page=new Page<Map<String, Object>>(pageNo,5);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.nested(p -> p.gt("sage", "2"));
        IPage<Map<String, Object>> mapIPage = studentMapper.selectMapsPage(page, wrapper);
        return mapIPage;
    }

    @ResponseBody
    @RequestMapping("selectPage/{pageNo}")
    public IPage<Student> selectPage(@PathVariable Integer pageNo){
        Page<Student> page = new Page<>(pageNo, 5);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.and(p -> p.gt("sage", "2"));
        IPage<Student> studentIPage = studentMapper.selectPage(page, wrapper);
        return studentIPage;
    }


    @ResponseBody
    @RequestMapping("selectList")
    public List<Student> selectList(){
        List<Student> students = studentMapper.selectList(null);
        return students;
    }

    /**
     * 信息管理系 -》 姓张的，年龄大于19， 的男性
     */
    @ResponseBody
    @RequestMapping("selectList1")
    public List<Student> selectList1(){
        List<Student> list = new LambdaQueryChainWrapper<Student>(studentMapper).eq(Student::getDept, "信息管理系").
                likeRight(Student::getSname, "张").gt(Student::getSage, 19).eq(Student::getSsex, "男").list();
        return list;
    }
    /**
     * 使用Lambda,名字为张姓（年龄大于19或部门不为空）
     */
    @ResponseBody
    @RequestMapping("selectList2")
    public List<Student> selectList2(){
        LambdaQueryWrapper<Student> lambda = new LambdaQueryWrapper<Student>();
        lambda.like(Student::getSname,"张")
                .and( student->student.gt(Student::getSage,19).or().isNotNull(Student::getDept) );
        return studentMapper.selectList(lambda);
    }
}
