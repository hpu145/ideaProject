package com.kaishengit.hibernate;

import com.kaishengit.pojo.Student;
import com.kaishengit.pojo.Teacher;
import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangyu on 2017/11/28.
 */
public class ManyToManyTest {
    private Session session;
    @Before
    public void before() {
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
    }

    @After
    public void after() {
        session.getTransaction().commit();
    }

    @Test
    public void findStudent() {
        Student student = (Student) session.get(Student.class,5);
        System.out.println(student.getStudentName());

        Set<Teacher> teacherSet = student.getTeacherSet();
        for (Teacher teacher : teacherSet) {
            System.out.println(teacher.getId() + "--->" + teacher.getTeacherName());
        }
    }

    @Test
    public void save() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("newTeacher");
        session.save(teacher);
        Student student = (Student) session.get(Student.class,5);

      /* Set<Teacher> teacherSet = new HashSet<Teacher>();
        teacherSet.add(teacher);*/
        Set<Teacher> teacherSet = student.getTeacherSet();
        teacherSet.add(teacher);
        student.setTeacherSet(teacherSet);
    }


    @Test
    public void findUser() {
        User user = (User) session.get(User.class,6);
        System.out.println(user.getUserName());



    }




}
