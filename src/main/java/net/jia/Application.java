package net.jia;

import net.jia.Singleton.SingletonLazy;

public class Application {

    public static void main(String[] args) {

        SingletonLazy.getInstance().process();
    }
}
