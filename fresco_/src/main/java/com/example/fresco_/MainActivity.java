package com.example.fresco_;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity {
    private SimpleDraweeView DraweeView;
    private Uri uri  ;
    private String URL = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3064674694,445703165&fm=26&gp=0.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //写入路径
        uri = Uri.parse("http://h.hiphotos.baidu.com/image/pic/item/ca1349540923dd54e1964cb2dc09b3de9d824807.jpg");
        //强转类型
        DraweeView = findViewById(R.id.DraweeView);
        DraweeView.setAspectRatio(1f);
        DraweeView.setImageURI(uri);

    }

    /**
     * 圆角20f
     * @param view
     */
    public void yuan(View view) {
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(20f);
        DraweeView.setAspectRatio(1f);//设置默认比例
        DraweeView.getHierarchy().setRoundingParams(roundingParams);//设置圆角框架
        DraweeView.setImageURI(uri);//设置图片
    }

    /**
     * 圆形
     * @param view
     */
    public void yuan2(View view) {
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(20f);
        roundingParams.setRoundAsCircle(true);
        DraweeView.setAspectRatio(1f);//设置默认比例
        DraweeView.getHierarchy().setRoundingParams(roundingParams);//设置圆角框架
        DraweeView.setImageURI(uri);//设置图片
    }

    /**
     * 比例
     * @param view
     */
    public void bili(View view) {
        DraweeView.setAspectRatio(2f);//设置比例为默认的二倍
    }

    /**
     * 渐进
     * @param view
     */
    public void jianjin(View view) {
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .build();
        DraweeView.setController(controller);
    }

    /**
     * 加载动图
     * @param view
     */
    public void gif(View view) {
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(URL)
                .setAutoPlayAnimations(true)
                .build();
        DraweeView.setController(controller);
    }
}
