package com.example.week03demo.presenter;

import com.example.week03demo.contract.CartContract;
import com.example.week03demo.model.CartModel;
import java.util.HashMap;

public class CartPresenter extends CartContract.CartPresenter {

    public CartModel cartModel;
    public CartContract.CartView cartView;

    public CartPresenter(CartContract.CartView cartView) {
        this.cartModel = new CartModel();
        this.cartView = cartView;
    }

    @Override
    public void getCartPresenter(HashMap<String, String> params) {
        cartModel.getCartModel(params, new CartContract.CartModelCallBack() {
            @Override
            public void Success(String result) {
                cartView.Success(result);
            }

            @Override
            public void FailUre(String msg) {
                cartView.FailUre(msg);
            }
        });
    }
}
