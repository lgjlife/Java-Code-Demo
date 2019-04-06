package com.ch7.CreateBean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: swagger
 * @description: 学校类
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-01 18:09
 **/
//@Configuration
public class School {

    private  Member student;
    private  Member teacher;

    public School(Member student, Member teacher) {
        this.student = student;
        this.teacher = teacher;
    }
   //

    public Member getStudent() {
        return student;
    }

    public void setStudent(Member student) {
        this.student = student;
    }

    public Member getTeacher() {
        return teacher;
    }

    public void setTeacher(Member teacher) {
        this.teacher = teacher;
    }
}

@Configuration
class SchoolConfig {

    @Bean
    public   School schoolBean(@Qualifier("StudentBean_1") Student student, Teacher teacher){
        return new School(student,teacher);
    }
}
