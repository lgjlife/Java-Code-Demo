package com.mybatis.user.intercetor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;


//@Component
@Slf4j
@Intercepts(@Signature(type = Executor.class,
        method ="update",
        args ={MappedStatement.class,Object.class} ))
public class MyIntercetor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        log.info("MyIntercetor ...");

        Object result = invocation.proceed();

        log.info("result = " + result);

        return result;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
