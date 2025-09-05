package com.kruma.core.exception;

import com.kruma.core.configuration.ConfigurationManager;
import com.kruma.core.exception.entity.Constante;
import com.kruma.core.service.entity.ServiceResult;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by John on 27/06/2016.
 */
public class ExceptionManager {

    public static void HandleException(Exception exc_pException) {
        com.kruma.core.exception.entity.Exception obj_Exception = new com.kruma.core.exception.entity.Exception();
        obj_Exception.setMessage(exc_pException.getMessage());

//          TODO:Revisar el seteo de la excepcion
//        obj_Exception.setSource(exc_pException.getCause().toString());
//        obj_Exception.setStackTrace(exc_pException.getStackTrace().toString());

        com.kruma.core.exception.service.IException IException = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_NAME,
                com.kruma.core.exception.service.IException.class
        ).getClient();

        IException.HandleException(obj_Exception,
                ConfigurationManager.getDefault().getApplicationManager().getItem("ExceptionPolicyName").getValue()
                , new Callback<ServiceResult<Boolean>>() {
            @Override
            public void success(ServiceResult<Boolean> booleanServiceResult, Response response) {}
            @Override
            public void failure(RetrofitError error) {}
        });
    }
}
