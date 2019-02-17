package model;

import android.text.TextUtils;

import com.google.gson.Gson;

import net.OkHttpCallBack;
import net.OkHttpUtils;

import java.util.HashMap;

import api.Api;
import bean.SearchBean;
import constract.SearchConstract;

public class SearchModel implements SearchConstract.SearchModel {

    @Override
    public void show(HashMap<String, String> params, final ModelCallBack modelCallBack) {
        OkHttpUtils.getmInstance().Get(Api.SEARCH, params, new OkHttpCallBack() {
            @Override
            public void Success(String result) {
                if(!TextUtils.isEmpty(result)){
                    modelCallBack.Success(result);
                }
            }

            @Override
            public void FailUre(String msg) {
                if(modelCallBack != null){
                    modelCallBack.FailUre(msg);
                }
            }
        });
    }

    public interface ModelCallBack{
        void Success(String result);
        void FailUre(String msg);
   }
}
