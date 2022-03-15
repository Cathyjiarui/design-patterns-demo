package net.jia.Singleton;

public class SingletonLazy {

//    private static SingletonLazy instance;

    /**
     * 构造函数私有化
     */
    private SingletonLazy(){}

    public void process() {
        System.out.println("SingletonLazy方法 调用成功！");
    }

    /**
     * 第一种实现方式
     * 对外暴露一个方法获取类的对象
     * 线程不安全，多线程下存在安全问题
     */
//    public static SingletonLazy getInstance() {
//        if (instance == null) {
//            instance = new SingletonLazy();
//        }
//        return instance;
//    }

    /**
     * 第二种实现方式
     * 通过加锁 synchronized 保证单例
     * 采用synchronized对方法加锁，有很大的性能开销
     * 解决办法：锁粒度放小
     */
//    public static synchronized SingletonLazy getInstance() {
//        if (instance == null) {
//            instance = new SingletonLazy();
//        }
//        return instance;
//    }

    /**
     * 第三种实现方式
     * DCL 双重检查锁定 (Double-Checked-Locking),在多线程下保持高性能
     * <p>
     * 这是否安全，instance = new SingletonLazy();etonLazy()，并不是原子性操作
     * 1.分配空间给对象
     * 2.在空间内创建对象
     * 3.将对象赋值给引用instance
     * <p>
     * 假如线程 1 -》 3 -》 2 的顺序，会把值写回主内存，其他线程就会读取到instance最新的值，但是这个是不完全的对象
     * (指令重排)
     */
//    public static SingletonLazy getInstance() {
//        if (instance == null) {
//            synchronized (SingletonLazy.class) {
//                if (instance == null) {
//                    instance = new SingletonLazy();
//                }
//            }
//        }
//        return instance;
//    }

    private static volatile SingletonLazy instance;

    /**
     * volatile是java提供的关键词，可以禁止指令重排
     */
    public static SingletonLazy getInstance() {
        //第一重检查
        if (instance == null) {
            //锁定
            synchronized (SingletonLazy.class) {
                //第二重检查
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
