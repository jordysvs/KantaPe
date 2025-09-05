package com.kruma.core.notification.service;

import com.kruma.core.notification.entity.MailEntry;
import com.kruma.core.service.entity.ServiceResult;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by John on 27/06/2016.
 */
public interface INotification {

    @POST("/Send")
    void Send(
            @Path("MailEntry") MailEntry mm_pMailEntry,
            Callback<ServiceResult<Boolean>> callback);
}
