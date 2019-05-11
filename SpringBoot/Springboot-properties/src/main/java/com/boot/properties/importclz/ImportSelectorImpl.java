package com.boot.properties.importclz;

import com.boot.properties.config.AllConfigurationProperties;
import com.boot.properties.config.AutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@Configuration
@EnableConfigurationProperties(AllConfigurationProperties.class)
@Import(AutoConfiguration.class)
public class ImportSelectorImpl implements ImportSelector {

    @Autowired
    AllConfigurationProperties properties;

    @Autowired
    ApplicationContext context;

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        System.out.println("ImportSelectorImpl context = " + context);


        System.out.println("ImportSelectorImpl selectImports........");
        System.out.println("ImportSelectorImpl = " + properties);
        return new String[0];
    }
}
