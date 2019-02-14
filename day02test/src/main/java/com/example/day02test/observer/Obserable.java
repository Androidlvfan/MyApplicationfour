package com.example.day02test.observer;

import java.util.ArrayList;
import java.util.List;

public class Obserable implements IObservable {

    //IObserver选用集合的形式，因为被观察者不止一个，需要用集合
    List<IObserver> list = new ArrayList();

    /**
     * 通知消息
     */
    @Override
    public void notifyMeg() {
        if(list != null && list.size() > 0){
            for(IObserver iObserver : list){
                iObserver.receiveMsg("我是更新的消息");
            }
        }
    }

    @Override
    public void registerObserver(IObserver iObserver) {
        if(iObserver != null){
            if(!list.contains(iObserver)){
                list.add(iObserver);
            }
        }
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        if(iObserver != null){
            list.remove(iObserver);
        }
    }
}
