package proxy.jdk;

/**
 * @Project: IntelliJ IDEA
 * @Author: Zixiao Wang
 * @Description:
 * 切面增强
 **/

public class Advice {

    /**
    * @author: Zixiao Wang
    * @date: 8/6/2020
    * @param: []
    * @return: void
    * @description:
     * 前置增强
    **/
    public void before(){
        System.out.println("Before Enhancement");
    }
    
    /**
    * @author: Zixiao Wang
    * @date: 8/6/2020
    * @param: []
    * @return: void
    * @description:
     * 后置增强
    **/
    public void after(){
        System.out.println("After Enhancement");
    }
}
