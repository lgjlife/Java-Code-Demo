package com.springboot.importdemo;

import com.springboot.importselector.config.EnableImportSelector;
import com.springboot.importselector.pojo.ImportSelectorPojo;
import com.springboot.importselector.pojo.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableImportSelector
@SpringBootApplication
public class ImportDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(ImportDemoApplication.class, args);

        ImportSelectorPojo importSelectorPojo =  context.getBean(ImportSelectorPojo.class);
        importSelectorPojo.run();

        Student student =  context.getBean(Student.class);
        student.run();


    }

}
