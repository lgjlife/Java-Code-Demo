package com.shiro.shiro.filter;

import org.apache.shiro.web.filter.authz.PortFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @program: shiro
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-09-03 06:26
 **/
public class ShiroPortFilter extends PortFilter {

    private static final Logger log = LoggerFactory.getLogger("ShiroPortFilter");

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {


        log.info("ShiroPortFilter - isAccessAllowed");
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        log.info("ShiroPortFilter - onAccessDenied");

        return super.onAccessDenied(request, response, mappedValue);
    }


}
