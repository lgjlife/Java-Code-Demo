package com.boot.properties.importclz;

import com.boot.properties.config.AllConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class DeferredImportSelectorImpl implements DeferredImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        System.out.println("DeferredImportSelectorImpl selectImports.....");
        return new String[0];
    }
}
