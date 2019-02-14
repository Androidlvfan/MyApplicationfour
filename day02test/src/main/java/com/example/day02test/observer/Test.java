package com.example.day02test.observer;

public class Test {
    public static void main(String[] s){
        //创建被观察者
        Obserable obserable = new Obserable();
        //创建观察者
        Observer observer1 = new Observer();
        Observer observer2 = new Observer();
        Observer observer3 = new Observer();
        Observer observer4 = new Observer();

        //订阅
        obserable.registerObserver(observer1);
        obserable.registerObserver(observer2);
        obserable.registerObserver(observer3);
        obserable.registerObserver(observer4);
        //反注册
        obserable.removeObserver(observer1);

        //业务数据更新
        obserable.notifyMeg();
    }
}
