package aopAnno;

import org.springframework.stereotype.Component;

/**
 * @Project: IntelliJ IDEA
 * @Author: Zixiao Wang
 * @Description: 目标对象，继承接口并实现save显示方法
 **/

@Component("target")
public class Target implements TargetInterface {
    public void save() {
//        int i = 1 / 0;// 抛出异常
        System.out.println("Save running ...");

    }
}
