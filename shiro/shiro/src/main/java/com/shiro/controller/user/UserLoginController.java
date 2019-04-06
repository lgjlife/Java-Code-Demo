package com.shiro.controller.user;

import com.common.code.UserReturnCode;
import com.common.result.WebResult;
import com.shiro.dao.model.User;
import com.shiro.service.UserLoginService;
import com.utils.CheckNullUtil;
import com.utils.UserLogin;
import com.utils.session.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: shiro
 * @description: 用户登录Controller
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-31 04:49
 **/

@Controller
@RequestMapping("/user/login")
public class UserLoginController {

    private static final Logger log = LoggerFactory.getLogger("UserLoginController");
    @Autowired
    UserLoginService userLoginService;

    /** 
     * @description: 进入登陆页面
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 8/31/18 
    */ 
    @ApiOperation(value = "/user/login/into",nickname = "登录",notes = "进入登录页面")
    @GetMapping("/into")
    public String intoLoginPage(){
        log.info("/user/login/into");
        return  "/user/Login";
    }

    /** 
     * @description: 执行登录操作
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/2/18 
    */ 
    @ApiOperation(value = "/user/login/in",nickname = "登录",notes = "用户登录")
    @PostMapping("/in")
    @ResponseBody
    public WebResult login(@RequestBody Map<String,Object> iData){

        log.info("/user/login/in");
        WebResult webResult;

        String loginName = (String)iData.get("loginName");
        String loginPassword = (String)iData.get("loginPassword");

        if((CheckNullUtil.isNullString(loginName))
            || (CheckNullUtil.isNullString(loginPassword))){
            log.error("loginName or loginPassword is null");
        }
        log.info("loginName = " + loginName +  "  loginPassword = "  + loginPassword );
        Subject subject = SecurityUtils.getSubject();

        log.info("获取token................");
        UsernamePasswordToken token = new UsernamePasswordToken(loginName,loginPassword);
        log.info("认证状态:"+subject.isAuthenticated());
        try {
           // token.setRememberMe(true);
            log.info("用户：" + loginName + "正在登录......");
            subject.login(token);
            log.info("用户：" + loginName + "登录成功");

            User user = userLoginService.queryUser(loginName);
            SessionUtil.setSession(UserLogin.currentLoginUser,user,30);
            webResult = new  WebResult(UserReturnCode.LOGIN_SUCCESS);
        }catch(IncorrectCredentialsException ice){
            log.error("对用户[" + loginName + "]进行登录验证..验证未通过,错误的凭证");
            webResult = new WebResult(UserReturnCode.LOGIN_PASSWORD_ERR);

        }catch(LockedAccountException lae){
            log.error("对用户[" + loginName + "]进行登录验证..验证未通过,账户已锁定");

            webResult = new WebResult(UserReturnCode.LOGIN_LOCK_ACCOUNT);
        }catch(ExcessiveAttemptsException eae){
            log.error("对用户[" + loginName + "]进行登录验证..验证未通过,错误次数过多");
            webResult = new WebResult(UserReturnCode.LOGIN_PASSWORD_ERR_MORE);

        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            log.error("对用户[" + loginName + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            webResult = new WebResult(UserReturnCode.LOGIN_FAIL);
        }
        log.info("认证状态:"+subject.isAuthenticated());

        return webResult;
    }
    /** 
     * @description: 执行登出操作
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/2/18 
    */ 
    @ApiOperation(value = "/user/login/out",nickname = "登录",notes = "进入登录页面")
    @DeleteMapping("/out")
    public String logout(){
        log.info("/user/login/out");

        Subject subject = SecurityUtils.getSubject();

        subject.logout();

        //返回住登录界面
        return  "/home/HomePage";
    }

    

}
