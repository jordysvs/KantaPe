package com.kruma.core.notification;

import android.app.Notification;

import com.kruma.core.configuration.ConfigurationManager;
import com.kruma.core.notification.entity.Constante;
import com.kruma.core.notification.entity.MailEntry;
import com.kruma.core.service.entity.ServiceResult;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by John on 27/06/2016.
 */
public class NotificationManager {

    public static void Send(MailEntry mm_pMailEntry){

        com.kruma.core.notification.service.INotification INotification = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_NAME,
                com.kruma.core.notification.service.INotification.class
        ).getClient();

        INotification.Send(mm_pMailEntry, new Callback<ServiceResult<Boolean>>() {
            @Override
            public void success(ServiceResult<Boolean> booleanServiceResult, Response response) {
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }


    public void notify(int i, Notification build) {

    }

}
