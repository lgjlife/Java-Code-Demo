package com.ch9.within;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * @program: aop
 * @description: 使用 Args 获取 Aspect切点,失败 ，问题未解决，运行报错
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-03 01:13
 **/
//作用是把当前类标识为一个切面供容器读取
@Aspect
@Configuration
public class WithinAspect {

   // private  static final Logger log = (Logger) LoggerFactory.getLogger("ExecutionAspect.class");

    /**
     * @description: 切点定义
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/3/18
    */

     /*


     */
     //匹配指定的类,不包括其子类
    @Pointcut(value="within(com.ch9.within.advice.FirstWithinAdvice)")
    //匹配被注解的类,不包括其子类
   //  @Pointcut(value="@within(com.ch9.within.NeetAspect)")
    //匹配被注解的类
   // @Pointcut(value="@target(com.ch9.within.NeetAspect)") 编译异常
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
