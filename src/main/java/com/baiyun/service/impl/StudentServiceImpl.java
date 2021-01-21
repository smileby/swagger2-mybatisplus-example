package com.baiyun.service.impl;

import com.baiyun.mapper.StudentMapper;
import com.baiyun.model.Student;
import com.baiyun.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
