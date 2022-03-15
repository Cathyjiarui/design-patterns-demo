package net.jia.Singleton;

public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {

    }

    public static SingletonHungry getInstance() {
        return instance;
    }

    /**
     * 单例对象的方法
     */
    public void process() {
        System.out.println("SingletonHungry方法 调用成功！");
    }
}
