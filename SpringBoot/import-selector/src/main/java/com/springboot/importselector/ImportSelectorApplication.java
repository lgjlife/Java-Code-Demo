package com.springboot.importselector;

import com.springboot.importselector.config.EnableImportSelector;
import com.springboot.importselector.pojo.ImportSelectorPojo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableImportSelector
@SpringBootApplication
public class ImportSelectorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ImportSelectorApplication.class, args);

        ImportSelectorPojo  importSelectorPojo =  context.getBean(ImportSelectorPojo.class);
        importSelectorPojo.run();


    }

}
