package com.example.week03demo.model;

import com.example.week03demo.api.ApiUrl;
import com.example.week03demo.contract.CommdityContract;
import com.example.week03demo.utils.OkHttpUtils;
import com.example.week03demo.utils.OkhttpCallBack;
import java.util.HashMap;

public class CommodityModel implements CommdityContract.CommdityModel {

    @Override
    public void getCommdityModel(HashMap<String, String> params, final CommdityContract.CommdityModelCallBack CommdityModelCallBack) {
        OkHttpUtils.getmInstance().Get(ApiUrl.Commodity, params, new OkhttpCallBack() {
            @Override
            public void FailUre(String msg) {
                if(CommdityModelCallBack != null){
                    CommdityModelCallBack.FailUre(msg);
                }
            }

            @Override
            public void Success(String result) {
                if(CommdityModelCallBack != null){
                    CommdityModelCallBack.Success(result);
                }
            }
        });
    }
}
