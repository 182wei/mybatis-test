package com.wei;

import com.wei.dao.StudentDao;
import com.wei.domain.Student;
import com.wei.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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
    public  void testCountStudent(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
       int count=  dao.countStudent();
        System.out.println(count);
        
        sqlSession.close();
    }
    @Test
    public  void testSelectAllStudent(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> studentList=  dao.selectAllStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public  void testSelectLikeOne(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        String name="魏%";
       List<Student> studentList=dao.selectLikeOne(name);
        for (Student student : studentList) {

            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public  void testSelectStudentIf(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
     Student student=new Student();
     student.setName("魏棋");
     student.setAge(10);
        List<Student> studentList=dao.selecStudentIf(student);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }

        sqlSession.close();
    }
    @Test
    public  void testSelectStudentWhere(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("魏棋");
        student.setAge(10);
        List<Student> studentList =dao.selecStudentWhere(student);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }

        sqlSession.close();
    }
    @Test
    public  void testSelectForeachOne(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
       List<Integer> list= new ArrayList<>();
       list.add(1001);
       list.add(1002);
       List<Student> studentList=dao.selectForeachOne(list);
        for (Student student : studentList) {
            System.out.println(student);
        }


        sqlSession.close();
    }
    @Test
    public  void testSelectForeachTwo(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> stulist=new ArrayList<>();
        Student s1= new Student();
        s1.setId(1001);
        stulist.add(s1);
        s1=new Student();
        s1.setId(1002);
        stulist.add(s1);
        List<Student> studentList=dao.selectForeachTwo(stulist);
        for (Student student : studentList) {
            System.out.println(student);
        }


        sqlSession.close();
    }

}
