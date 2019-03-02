package com.example.week03demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week03demo.bean.CartBean;
import com.example.week03demo.bean.CommdityBean;
import com.example.week03demo.contract.CommdityContract;
import com.example.week03demo.presenter.CommodityPresenter;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

public class CommodityActivity extends AppCompatActivity implements CommdityContract.CommdityView {
private TextView commodity_namee,commodity_price;
private WebView commodity_WebView;
private CommodityPresenter commodityPresenter;
public String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity);


        commodity_namee = findViewById(R.id.commodity_namee);
        commodity_price = findViewById(R.id.commodity_price);
        commodity_WebView = findViewById(R.id.commodity_WebView);

        //支持缩放
        commodity_WebView.getSettings().setSupportZoom(true);
        //支持扩大比例的缩放
        commodity_WebView.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        commodity_WebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        commodity_WebView.getSettings().setLoadWithOverviewMode(true);


        commodityPresenter = new CommodityPresenter(this);
        HashMap<String,String> params = new HashMap<>();
        params.put("commodityId",id);
        commodityPresenter.getCommdityPresenter(params);

        //eventBus接收值
        EventBus.getDefault().register(this);

    }

    @Subscribe(sticky = true)
    public void getId(String CommodityId){
        id = CommodityId;
    }

    /**
     * 详情页请求成功
     * @param result
     */
    @Override
    public void Success(String result) {
        CommdityBean commdityBean = new Gson().fromJson(result, CommdityBean.class);
        /*commodity_namee.setText(commdityBean.getResult().getCommodityName());
        commodity_price.setText(commdityBean.getResult().getPrice()+"");*/

        //设置webView
        commodity_WebView.setWebChromeClient(new WebChromeClient());
        commodity_WebView.loadDataWithBaseURL(null,commdityBean.getResult().getDetails(),"textxml","utf-8",null);
    }

    @Override
    public void FailUre(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
