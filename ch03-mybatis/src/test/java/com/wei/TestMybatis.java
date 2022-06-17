package com.wei;

import com.github.pagehelper.PageHelper;
import com.wei.dao.StudentDao;
import com.wei.domain.Student;
import com.wei.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
 @Test
    public void testSelectStudents(){
 SqlSession sqlSession=MybatisUtil.getsqlsession();
 //动态代理
     StudentDao dao=sqlSession.getMapper(StudentDao.class);
    Student student=   dao.selectStudentById(1002);
     System.out.println(student);
 }
 @Test
    public  void testSelectMultiParam(){
     SqlSession sqlSession=MybatisUtil.getsqlsession();

     StudentDao dao= sqlSession.getMapper(StudentDao.class);
    List<Student> studentList= dao.selectMultiParam("李四",28);
     for (Student student : studentList) {
         System.out.println(student);
     }
     sqlSession.close();

 }
 @Test
    public  void testSelectMultiStudent(){
     SqlSession sqlSession=MybatisUtil.getsqlsession();
     StudentDao dao=sqlSession.getMapper(StudentDao.class);
     Student student= new Student();
     student.setName("魏棋");
     student.setAge(20);
     List<Student> studentList=dao.selectMultiStudent(student);
     for (Student student1 : studentList) {
         System.out.println(student1);
     }
     sqlSession.close();
 }
    @Test
    public  void testSelectAll(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();

        StudentDao dao= sqlSession.getMapper(StudentDao.class);
        PageHelper.startPage(1,3);
       List<Student> studentList=dao.selectAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();

    }


}
