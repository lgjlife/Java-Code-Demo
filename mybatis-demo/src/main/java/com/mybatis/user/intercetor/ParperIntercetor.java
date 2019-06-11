package com.mybatis.user.intercetor;

import com.mybatis.user.reflect.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;



@Slf4j
/*@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
), @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class, CacheKey.class, BoundSql.class}
)})*/

@Intercepts(@Signature(type = StatementHandler.class,
        method ="parameterize",
        args ={Statement.class} ))
public class ParperIntercetor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        log.info("StatementHandler Statement...................................");

        RoutingStatementHandler routingStatementHandler = (RoutingStatementHandler) invocation.getTarget();
        StatementHandler statementHandler1 = (StatementHandler)ReflectUtil.getFieldValue(routingStatementHandler,"delegate");
        BoundSql boundSql = statementHandler1.getBoundSql();


        String sql = boundSql.getSql();
        String pageSql = sql + " limit 1";;//操作sql
        //再通过反射把新sql设置进去
        ReflectUtil.setFieldValue(boundSql, "sql", pageSql);

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
