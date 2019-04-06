package com.ch9.execution;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * @program: aop
 * @description: 使用 Execution 获取 Aspect切点
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-03 01:13
 **/
//作用是把当前类标识为一个切面供容器读取
@Aspect
@Configuration
public class ExecutionAspect {

   // private  static final Logger log = (Logger) LoggerFactory.getLogger("ExecutionAspect.class");

    /**
     * @description: 切点定义
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 7/3/18
    */

     /*
    execution(<修饰符模式>  <返回类型> <类名+方法名> (参数))
    1. execution(public * *(..)):匹配所有目标类的所有public方法
    2. execution(* *Num(..)):匹配目标类的以Num结尾的方法
    3. execution(* com.boot.Advice.*(..)):匹配com.boot.Advice类下的方法
    4. execution(* com.boot.Advice+.*(..)):匹配com.boot.Advice接口以及其实现类的方法
    5. execution(* com.boot.*(..)):匹配com.boot.包下的方法
    6. execution(* com.boot..*(..)):匹配com.boot包以及子孙包的方法
    7. execution(* com..Advice.*(..)):..多层包
    8. execution(* *(String,Integer)):匹配入参
    9. execution(* *(String,*)):匹配入参
    10. execution(* *(String,..)):匹配入参,第一个参数必须为String,后面为任意参数
    10. execution(* *(Object+,..)):匹配入参,第一个参数必须为Object类或者子类,后面为任意参数

     */


   // @Pointcut(value="execution(protected * com.ch9.execution.advice.*.*(..))")
   // @Pointcut(value="execution(* *func3(..))")
    @Pointcut(value="execution(* com.ch9.execution.advice.*.*(String,Integer))")
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
