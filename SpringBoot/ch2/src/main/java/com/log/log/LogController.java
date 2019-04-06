package com.log.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private static final Logger log = LoggerFactory.getLogger(LogController.class);
    @RequestMapping("/log")
    public String  log(){
        log.trace("LogController======trace");
        log.debug("LogController======debug");
        log.warn("LogController======warn");
        log.error("LogController======error");
        return "This is a log test";
    }
}
