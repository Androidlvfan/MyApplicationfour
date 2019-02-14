package com.example.day02test.observer;

public interface IObserver {
    void receiveMsg(String msg);//接收消息---消息的类型不一定是String 可以是对象类型的。
}
