package com.example.week03demo.utils;

import com.example.week03demo.myApp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class myInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("userId","21");
        builder.addHeader("sessionId","155148935559821");
        //builder.addHeader("userId",SpUtil.getString(myApp.context,"userId",null));
        //builder.addHeader("sessionId",SpUtil.getString(myApp.context,"sessionId",null));
        Request build = builder.build();
        Response response = chain.proceed(build);
        return response;
    }
}
