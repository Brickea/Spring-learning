package aopAnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Project: IntelliJ IDEA
 * @Author: Zixiao Wang
 * @Description: 使用spring融入的 aspectj 进行切面编程
 * 此为切面类
 * 切面类中包含增强方法
 **/
@Component("myAspect")
@Aspect
public class MyAspect {

    /**
    * @author: Zixiao Wang
    * @date: 8/6/2020
    * @param: []
    * @return: void
    * @description:
     * 注解的方式定义切点抽取表达式
    **/
    @Pointcut("execution(* aopAnno.*.*(..))")
    public void myPoint() {
    }


    @Before("MyAspect.myPoint()")
    public void before() {
        System.out.println("增强before");
    }


    /**
     * @author: Zixiao Wang
     * @date: 8/6/2020
     * @param: [proceedingJoinPoint]
     * @return: java.lang.Object
     * @description: 环绕增强
     * 当正在执行的连接点===切点的时候执行
     **/
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("环绕前增强");

        Object proceed = proceedingJoinPoint.proceed(); // 切点方法

        System.out.println("环绕后增强");

        return proceed;

    }

    public void afterReturning() {
        System.out.println("切入点方法执行后增强");
    }

    /**
     * @author: Zixiao Wang
     * @date: 8/6/2020
     * @param: []
     * @return: void
     * @description: 此增强不管抛不抛异常都会执行
     **/
    public void after() {
        System.out.println("无论是否正常执行，都会增强");
    }

    public void afterThrowing() {
        System.out.println("抛出异常后增强");
    }


}
