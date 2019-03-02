package com.example.week03demo.model;

import com.example.week03demo.api.ApiUrl;
import com.example.week03demo.contract.CartContract;
import com.example.week03demo.utils.OkHttpUtils;
import com.example.week03demo.utils.OkhttpCallBack;
import java.util.HashMap;

public class CartModel implements CartContract.CartModel {

    @Override
    public void getCartModel(HashMap<String, String> params, final CartContract.CartModelCallBack CartModelCallBack) {
        OkHttpUtils.getmInstance().Get(ApiUrl.Cart_Show, params, new OkhttpCallBack() {
            @Override
            public void FailUre(String msg) {
                if(CartModelCallBack != null){
                    CartModelCallBack.FailUre(msg);
                }
            }

            @Override
            public void Success(String result) {
                if(CartModelCallBack != null){
                    CartModelCallBack.Success(result);
                }
            }
        });
    }
}
