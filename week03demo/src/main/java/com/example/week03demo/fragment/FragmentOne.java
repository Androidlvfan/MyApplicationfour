package com.example.week03demo.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.week03demo.CommodityActivity;
import com.example.week03demo.R;
import com.example.week03demo.adapter.CartAdapter;
import com.example.week03demo.bean.CartBean;
import com.example.week03demo.contract.CartContract;
import com.example.week03demo.presenter.CartPresenter;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

public class FragmentOne extends Fragment implements CartContract.CartView ,CartAdapter.ItemOnclick {
    private CartPresenter cartPresenter;
    private CartAdapter cartAdapter;
    private RecyclerView Cart_Rcv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        Cart_Rcv = view.findViewById(R.id.Cart_Rcv);
        cartPresenter = new CartPresenter(this);

        HashMap<String,String> params = new HashMap<>();
        cartPresenter.getCartPresenter(params);

        return view;
    }

    /**
     * 购物车执行成功
     * @param result
     */
    @Override
    public void Success(String result) {
        CartBean cartBean = new Gson().fromJson(result, CartBean.class);
        List<CartBean.ResultBean> cartBeanResult = cartBean.getResult();
        cartAdapter = new CartAdapter(getActivity(),cartBeanResult);
        cartAdapter.setItemOnclick(this);
        Cart_Rcv.setAdapter(cartAdapter);
        Cart_Rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void FailUre(String msg) {
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 接口回调
     * @param CommodityId
     */
    @Override
    public void OnClick(int CommodityId) {
        Toast.makeText(getActivity(),"你点击了",Toast.LENGTH_SHORT).show();
        //eventBus进行传值
        EventBus.getDefault().postSticky(CommodityId+"");
        Intent intent = new Intent(getActivity(),CommodityActivity.class);
        startActivity(intent);
    }
}
