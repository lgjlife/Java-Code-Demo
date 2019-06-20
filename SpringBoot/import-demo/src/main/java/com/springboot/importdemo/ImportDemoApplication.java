package com.springboot.importdemo;

import com.springboot.importselector.config.EnableImportSelector;
import com.springboot.importselector.pojo.House;
import com.springboot.importselector.pojo.Location;
import com.springboot.importselector.pojo.User;
import com.springboot.importselector.pojo.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableImportSelector(value = "xxx")
@SpringBootApplication
public class ImportDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(ImportDemoApplication.class, args);

        String[] beanNames =  context.getBeanDefinitionNames();
        for(String name: beanNames){
            System.out.println(name);
        }

        User user =  context.getBean(User.class);
        user.run();

        Student student =  context.getBean(Student.class);
        student.run();

        House house =  context.getBean(House.class);
        house.run();


        Location location =  context.getBean(Location.class);
        location.run();


    }

}
