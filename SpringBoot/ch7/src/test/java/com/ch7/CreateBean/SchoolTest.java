package com.ch7.CreateBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//Spring boot Tesz自动配置
@SpringBootTest
public class SchoolTest {

    @Autowired
    School  school;

    @Autowired
    @Qualifier("StudentBean_2")
    Student student;

    @Autowired
    Teacher teacher;

    @Test
    public void schoolTest(){

        System.out.println("Student -- " + student.toString() );
        System.out.println("Teacher -- " + teacher.toString() );

        System.out.println(school.getStudent().toString());
        System.out.println(school.getTeacher().toString());


        /*System.out.println("School is null?--" + (school == null));
        System.out.println("Student is null?--" + (student == null));
        System.out.println("Teacher is null?--" + (teacher == null));



        System.out.println("Student -- " + student.toString() );
        System.out.println("Teacher -- " + teacher.toString() );
        */
    }

}