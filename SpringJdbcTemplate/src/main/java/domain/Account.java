package domain;

/**
 * @Project: IntelliJ IDEA
 * @Author: Zixiao Wang
 * @Description:
 * 账户实体
 **/

public class Account {

    private String name;
    private float money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
