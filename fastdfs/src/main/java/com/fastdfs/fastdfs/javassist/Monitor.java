package com.fastdfs.fastdfs.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class Monitor {

    @PostConstruct
    public void init() {

        log.info("Monitor　...........");
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass ct = pool.getCtClass("com.github.tobato.fastdfs.domain.proto.ProtoHead");
            CtMethod m = ct.getDeclaredMethod("createFromInputStream");
            m.insertBefore("System.out.print(\"＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋\");");
            ct.writeFile();
        } catch (Exception ex) {
            log.error(ex.getMessage());

        }
    }
}
