package com.kruma.core.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kruma.core.configuration.ConfigurationManager;
import com.kruma.core.service.entity.converter.DotNetDateConverter;
import com.squareup.okhttp.OkHttpClient;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by Enrique on 17/06/2016.
 */
public class ServiceManager{

    private String str_Path;
    private Object cls_Service;

    public ServiceManager(String str_pServiceName, Object cls_pService) {
        this.str_Path = ConfigurationManager.getDefault().getServiceManager().getItem(str_pServiceName).getPath();
        this.cls_Service = cls_pService;
    }

    public <T> T getClient() {
        GsonBuilder gson_Builder = new GsonBuilder();
        gson_Builder
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .registerTypeAdapter(Date.class, new DotNetDateConverter());

         RestAdapter rst_adapter = new RestAdapter.Builder()
                .setEndpoint(str_Path)
                .setClient(new OkClient(getConnection()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson_Builder.create()))
                .build();
        return (T) rst_adapter.create((Class<T>)cls_Service);
    }

    private OkHttpClient getConnection() {
        OkHttpClient obj_client = new OkHttpClient();
        obj_client.setConnectTimeout(2, TimeUnit.MINUTES);
        obj_client.setReadTimeout(2, TimeUnit.MINUTES);
        return obj_client;
    }
}


