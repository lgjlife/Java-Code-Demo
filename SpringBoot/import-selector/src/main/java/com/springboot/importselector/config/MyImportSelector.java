package com.springboot.importselector.config;

import com.springboot.importselector.pojo.ImportSelectorPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;



@Slf4j
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        log.info("MyImportSelector selectImports ...");
        return new String[]{
            ImportSelectorPojo.class.getName()};
    }
}
