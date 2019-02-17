package com.example.day03test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import adapter.SearchAdapter;
import bean.SearchBean;
import constract.SearchConstract;
import presenter.SearchPresenter;

public class MainActivity extends AppCompatActivity implements SearchConstract.SearchView {
private RecyclerView mrecyclerView;
private SearchAdapter searchAdapter;
private SearchPresenter searchPresenter;
private ImageView sousuo;
private EditText edit;
private String keyword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //点击
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = edit.getText().toString();
                HashMap<String,String> params = new HashMap<>();
                params.put("keyword",keyword);
                params.put("page","1");
                params.put("count","5");
                searchPresenter.show(params);
            }
        });
        searchPresenter = new SearchPresenter(MainActivity.this);
    }

    private void initView() {
        mrecyclerView = findViewById(R.id.mrecyclerView);
        sousuo = findViewById(R.id.sousuo);
        edit = findViewById(R.id.edit);
        mrecyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    /**
     * 关键字搜索成功
     * @param result
     */
    @Override
    public void Success(String  result) {
        SearchBean searchBean = new Gson().fromJson(result, SearchBean.class);
       searchAdapter = new SearchAdapter(this,searchBean.getResult());

    mrecyclerView.setAdapter(searchAdapter);
    }

    /**
     * 关键字搜索执行失败
     * @param msg
     */
    @Override
    public void FailUre(String msg) {
        Toast.makeText(MainActivity.this,"加载失败",Toast.LENGTH_SHORT).show();
    }
}
