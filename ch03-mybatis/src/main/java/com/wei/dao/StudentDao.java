package com.wei.dao;

import com.wei.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//接口操作Student01表
public interface StudentDao {
 public  Student selectStudentById(Integer id);
 public List<Student> selectMultiParam(@Param("myname")String name, @Param("myage")Integer age);
 public List<Student> selectMultiStudent(Student student);
 List<Student> selectAll();


}
