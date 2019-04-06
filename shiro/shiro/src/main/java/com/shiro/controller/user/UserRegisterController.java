package com.shiro.controller.user;

import com.common.code.NullPointerCode;
import com.common.code.ReturnCode;
import com.common.result.WebResult;
import com.shiro.service.UserRegisterService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: shiro
 * @description: 用户注册Controller
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-31 19:03
 **/

@Controller
@RequestMapping("/user/register")
public class UserRegisterController {

    private static final Logger log = LoggerFactory.getLogger("UserRegisterController");

    @Autowired
    UserRegisterService userRegisterService;
    /** 
     * @description:  进入注册页面
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 8/31/18 
    */ 
    @ApiOperation(value = "/user/register/into",nickname = "注册页面",notes = "进入注册页面")
    @GetMapping("/into")
    public String registerInto(){
        log.info("/user/register/into");
        return "/user/Register";
    }

    /**
     * @description: 查询用户名/手机号/邮箱是否存在已经注册
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/2/18 
    */
    @ApiOperation(value = "/user/register/check-register-name",
            notes = "查询用户名/手机号/邮箱是否存在已经注册")
    @PostMapping("/check-register-name")
    @ResponseBody
    public WebResult checkLoginName(@RequestParam String registerName){
        log.info("/user/register/check-register-name");
        log.info("registerName = " + registerName);
        if((registerName != null)|| (registerName != "")){
            ReturnCode code = userRegisterService.checkRegisterName(registerName);
            WebResult webResult = new WebResult(code);
            return  webResult;
        }
        else {
            return new WebResult(NullPointerCode.Null_Pointer);
        }
    }

    /** 
     * @description:  用户提交注册请求
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 9/2/18 
    */ 
    @ApiOperation(value = "/user/register/register",
            notes = "用户提交注册")
    @PostMapping("/register")
    @ResponseBody
    public WebResult register(@RequestBody Map<String,String> obj){

        log.info("/user/register/register");
        String registerName = obj.get("registerName");
        String password = obj.get("password");

        log.info("registerName = " + registerName  + "  password = " + password);

        if((registerName == null )||(registerName == "")
                || (password == null) ||(password == "") ){
            return new WebResult(NullPointerCode.Null_Pointer);
        }
        else{

            ReturnCode code = userRegisterService.register(registerName,password);
            return new WebResult(code);
        }


    }
}
