package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Project: IntelliJ IDEA
 * @Author: Zixiao Wang
 * @Description:
 **/

public class CglibTest {
    public static void main(String[] args) {
        // 目标对象
        final Target target = new Target();

        // 增强对象
        final Advice advice = new Advice();

        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 1. 设置目标函数
        enhancer.setSuperclass(Target.class);
        // 2. 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 执行前置
                advice.before();
                // 执行目标
                Object invoke = method.invoke(target,objects);
                // 执行后置
                advice.after();
                return invoke;
            }
        });

        Target proxy = (Target) enhancer.create();

        proxy.save();
    }
}
