package com.example.week03demo.contract;

import java.util.HashMap;

public interface CartContract {
        /**
         * p
         */
        public abstract class CartPresenter{
            public abstract void getCartPresenter(HashMap<String,String> params);
        }
        /**
         * m
         */
        public interface CartModel{
            void getCartModel(HashMap<String,String> params,CartModelCallBack CartModelCallBack);
        }
        /**
         * v
         */
        public interface CartView{
            void Success(String result);
            void FailUre(String msg);
        }
        /**
         * modelCallback
         */
        public interface CartModelCallBack{
            void Success(String result);
            void FailUre(String msg);
        }
    }

