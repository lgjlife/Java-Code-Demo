package com.shiro.shiro.filter;

import org.apache.shiro.web.servlet.AdviceFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @program: shiro AdviceFilter 类似于AOP,其将会对@Controller类进行拦截
 * 
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-03 03:44
 **/

//@Component
public class ShiroAdviceFilter extends AdviceFilter {

    private static final Logger log = LoggerFactory.getLogger("ShiroAdviceFilter");

    /** 
     * @description:   类似AOP的前置增强
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/3/18 
    */ 
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        log.info("ShiroAdviceFilter -- preHandle");
        return super.preHandle(request, response);
    }

    /** 
     * @description:  类似AOP的后置返回增强
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/3/18 
    */ 
    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
        log.info("ShiroAdviceFilter -- postHandle");
        super.postHandle(request, response);
    }
    /** 
     * @description: 类似AOP的前置最终增强，不管有没有异常都会执行
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/3/18 
    */ 
    @Override
    public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception) throws Exception {
        log.info("ShiroAdviceFilter -- afterCompletion");
        super.afterCompletion(request, response, exception);
    }
}
