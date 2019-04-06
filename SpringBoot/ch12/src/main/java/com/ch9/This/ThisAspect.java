package com.ch9.This;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * @program: aop
 * @description: 使用 Target 获取 Aspect切点
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-03 01:13
 **/
//作用是把当前类标识为一个切面供容器读取
@Aspect
@Configuration
public class ThisAspect {

   // private  static final Logger log = (Logger) LoggerFactory.getLogger("ExecutionAspect.class");

    /**
     * @description: 切点定义
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/3/18
    */

     /*
       this 按类型匹配，仅接受类名入参，使用+或者不使用没有区别

      this(com.ch9.target.advice.TargetAdvice) : 匹配类或者子类为TargetAdvice的所有方法

     */

    @Pointcut(value="target(com.ch9.This.advice.FirstThisAdvice)")
    public void pointcut(){};

    /**
     * @description: 前置增强
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/3/18
    */

    @Before("pointcut()")
    public  void before(JoinPoint jp){
        System.out.println("AOP-----执行 ExecutionAspect -- before");

    }

    /**
     * @description: 后置增强
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/3/18
     */
   @After("pointcut()")
    public  void after(JoinPoint jp){
        System.out.println("AOP-----执行 ExecutionAspect -- after");
    }

    /**
     * @description: 返回增强
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/3/18
     */
    @AfterReturning("pointcut()")
    public  void afterReturning(JoinPoint jp){
        System.out.println("AOP-----执行 ExecutionAspect -- afterReturning");
        printJoinPoint(jp);
    }

    /**
     * @description: 异常增强
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/3/18
     */
    @AfterThrowing(pointcut="pointcut()",throwing="ex")
    public  void afterThrowing(JoinPoint jp,Throwable ex){
        System.out.println("AOP-----执行 ExecutionAspect -- afterThrowing");
    }

    /**
     * @description: 环绕增强
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/3/18
     */
    @Around("pointcut()")
    public  void around(ProceedingJoinPoint pjp) throws  Throwable{
        System.out.println("AOP-----执行 ExecutionAspect -- around执行前");
        pjp.proceed();
        System.out.println("AOP-----执行 ExecutionAspect -- around执行后");
    }


   private  void printJoinPoint(JoinPoint jp){

       Object target =   jp.getTarget();
       Object[] args =  jp.getArgs();
       String kind = jp.getKind();
       Signature signature = jp.getSignature();
       System.out.println("-------------------");
       System.out.println("  target = " + target.toString() + "\r\n"
                         + "  args = " + args.toString() + "\r\n"
               + "  kind = " + kind + "\r\n"
               + "  signature = " + signature.toString() + "\r\n"
       );

       for(Object arg:args){
           System.out.println("  " + arg.toString());
       }
       System.out.println("-------------------");

   }


}
