package com.wei;

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
     StudentDao dao=sqlSession.getMapper(StudentDao.class);
     List<Student>  studentList=dao.selectStudents();
     for (Student student : studentList) {
         System.out.println("学生="+student);
     }
 }
 @Test
    public  void  testInsertStudents(){
     SqlSession sqlSession=MybatisUtil.getsqlsession();
     StudentDao dao=  sqlSession.getMapper(StudentDao.class);
     Student student=new Student();
     student.setId(1004);
     student.setName("魏棋");
     student.setEmail("weiqi@qq.com");
     student.setAge(21);
    int num= dao.insertStudent(student);
    sqlSession.commit();
     System.out.println("添加的数量"+num);
 }

    @Test
    public void testSelectStudent(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> student = dao.selectStudent(new Student(null, "张飞", "", 0));
        System.out.println(student);
    }
}
