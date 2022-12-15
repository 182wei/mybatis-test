package com.wei;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wei.dao.StudentDao;
import com.wei.domain.Student;
import com.wei.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;


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
     student.setName("魏棋");
     student.setEmail("weiqi@qq.com");
     student.setAge(21);
    int num= dao.insertStudent(student);
    sqlSession.commit();
     System.out.println("添加的数量"+num);
     System.out.println(student);
     System.out.println(student);
 }

    @Test
    public void testSelectStudent(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> student = dao.selectStudent(new Student(null, "张飞", "", 0));
        System.out.println(student);
    }

    @Test
    public  void  batch(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=  sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("xsdahd1");
        Student student1=new Student();
        student1.setName("xsdahd2");
        Student student2=new Student();
        student2.setName("xsdahd3");
        List<Student> studentList = Arrays.asList(student, student1, student2);
        int batch = dao.batch(studentList);
        sqlSession.commit();
        System.out.println(batch);
    }

    @Test
    public void deleteBatch(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Integer arr[] = new Integer[]{1110,1100,1101};
        int result = dao.deleteBatch(arr);
        sqlSession.commit();
        System.out.println(result);
        System.out.println(result);
    }


    @Test
    public void queryStudentById(){
        SqlSession sqlSession=MybatisUtil.getsqlsession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Optional<Student> student = dao.queryStudentById(1);
        System.out.println("=====");
        System.out.println(student);
        if (student.isPresent()) {
        System.out.println(student.get().getAge());
        }
        Student student2 = student.filter(student1 -> student1.getAge() >60 ).orElseGet(Student::new);
        System.out.println(student2.getName());
        student.ifPresent(student1 -> student1.getName());

        Student student1 = student.orElseGet(Student::new);
        System.out.println(student1);
        System.out.println(student1.getAge());
    }
    @Test
    public void Test01() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "{\"name\":\"Hyl\", \"age\":20}";
        Student student = mapper.readValue(jsonString, Student.class);
        System.out.println(student);
    }
}
