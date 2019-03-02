package com.example.week03demo.presenter;

import com.example.week03demo.contract.CommdityContract;
import com.example.week03demo.model.CommodityModel;
import java.util.HashMap;

public class CommodityPresenter extends CommdityContract.CommdityPresenter {

    private CommodityModel commodityModel;
    private CommdityContract.CommdityView commdityView;

    public CommodityPresenter(CommdityContract.CommdityView commdityView) {
        this.commodityModel = new CommodityModel();
        this.commdityView = commdityView;
    }

    @Override
    public void getCommdityPresenter(HashMap<String, String> params) {
        commodityModel.getCommdityModel(params, new CommdityContract.CommdityModelCallBack() {
            @Override
            public void Success(String result) {
                commdityView.Success(result);
            }

            @Override
            public void FailUre(String msg) {
                commdityView.FailUre(msg);
            }
        });
    }
}
