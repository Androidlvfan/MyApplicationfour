package com.example.week03demo.contract;

import java.util.HashMap;

public interface CommdityContract {
        /**
         * p
         */
        public abstract class CommdityPresenter{
            public abstract void getCommdityPresenter(HashMap<String,String> params);
        }
        /**
         * m
         */
        public interface CommdityModel{
            void getCommdityModel(HashMap<String, String> params, CommdityModelCallBack CommdityModelCallBack);
        }
        /**
         * v
         */
        public interface CommdityView{
            void Success(String result);
            void FailUre(String msg);
        }
        /**
         * modelCallback
         */
        public interface CommdityModelCallBack{
            void Success(String result);
            void FailUre(String msg);
        }
    }

