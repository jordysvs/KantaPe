package com.kruma.core.log.service;

import com.kruma.core.log.entity.LogEntry;
import com.kruma.core.service.entity.ServiceResult;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by John on 27/06/2016.
 */
public interface ILog {

    @POST("/WriteEntry")
    void WriteEntry(
            @Path("Config")String str_pConfig,
            @Path("Entry")LogEntry let_pEntry,
            Callback<ServiceResult<Boolean>> callback);

    @POST("/Write")
    void Write(
            @Path("Config")String str_pConfig,
            @Path("Title")String str_pTitle,
            @Path("Message")String str_pMessage,
            Callback<ServiceResult<Boolean>> callback);
}
