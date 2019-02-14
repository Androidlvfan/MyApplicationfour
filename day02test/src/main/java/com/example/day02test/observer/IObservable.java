package com.example.day02test.observer;

public interface IObservable {
    void notifyMeg();//通知消息给观察者，用于接收
    void registerObserver(IObserver iObserver);//注册观察者
    void removeObserver(IObserver iObserver);//反注册观察者
}
