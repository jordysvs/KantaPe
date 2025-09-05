package com.kruma.core.log;

import com.kruma.core.log.entity.Constante;
import com.kruma.core.log.entity.LogEntry;
import com.kruma.core.configuration.ConfigurationManager;
import com.kruma.core.service.entity.ServiceResult;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by John on 27/06/2016.
 */
public class LogManager {

    public static void Write(String str_pConfig, LogEntry let_pEntry) {
        com.kruma.core.log.service.ILog ILog = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_NAME,
                com.kruma.core.log.service.ILog.class
        ).getClient();

        ILog.WriteEntry(str_pConfig, let_pEntry, new Callback<ServiceResult<Boolean>>() {
            @Override
            public void success(ServiceResult<Boolean> booleanServiceResult, Response response) {
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    public static void Write(String str_pConfig, String str_pTitle, String str_pMessage) {
        com.kruma.core.log.service.ILog ILog = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_NAME,
                com.kruma.core.business.service.IModulo.class
        ).getClient();

        ILog.Write(str_pConfig, str_pTitle, str_pMessage, new Callback<ServiceResult<Boolean>>() {
            @Override
            public void success(ServiceResult<Boolean> booleanServiceResult, Response response) {
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });

    }
}
