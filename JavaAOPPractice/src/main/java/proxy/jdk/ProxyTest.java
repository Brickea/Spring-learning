package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Project: IntelliJ IDEA
 * @Author: Zixiao Wang
 * @Description:
 **/

public class ProxyTest {

    public static void main(String[] args) {

        // 目标对象
        final Target target = new Target();

        // 增强对象
        final Advice advice = new Advice();

        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标对象的类加载器
                target.getClass().getInterfaces(),// 目标对象相同的接口字节码数组
                new InvocationHandler() {
                    // 调用代理对象的任何方法，实际执行的是 invoke 方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 前置增强
                        advice.before();
                        method.invoke(target,args);
                        // 后置增强
                        advice.after();

                        return null;
                    }
                }
        );

        proxy.save();
    }
}
