package com.wei.dao;

import com.wei.domain.Student;

import java.util.List;

//接口操作Student01表
public interface StudentDao {
    //查询student01表得所有数据
    public List<Student> selectStudents();
    //添加数据
     public int insertStudent(Student student);

    Student selectStudentById(int i);

    //动态if标签
   List<Student> selectStudent(Student student);

}
