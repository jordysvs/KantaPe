package com.kruma.core.service.entity;

import com.kruma.core.configuration.ConfigurationManager;
import com.kruma.core.util.common.OperationResult;
import com.kruma.core.util.common.ProcessResult;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by John on 21/06/2016.
 */
public abstract class ServiceCallback<T> implements retrofit.Callback<ServiceResult<T>> {

    @Override
    public void success(ServiceResult<T> obj_pResultado, Response obj_pResponse) {
        try {
            if (obj_pResultado.getMensaje() == "") {
                if (obj_pResultado.getResultado() instanceof com.kruma.core.util.common.ProcessResult) {
                    if (((ProcessResult) obj_pResultado.getResultado()).operationResult == OperationResult.Success) {
                        success(obj_pResultado.getResultado());
                    }
                    else {
                        failure(((ProcessResult) obj_pResultado.getResultado()));
                    }
                } else {
                    success(obj_pResultado.getResultado());
                }
            } else {
                throw new Exception(obj_pResultado.getMensaje());
            }
        } catch (Exception obj_pExcepcion) {
            failure(new com.kruma.core.util.common.ProcessResult(obj_pExcepcion));
        }
    }

    @Override
    public void failure(RetrofitError obj_pError) {
        failure(new com.kruma.core.util.common.ProcessResult(new Exception(
                ConfigurationManager.getDefault().getApplicationManager().getItem("MensajeError").getValue())));
    }

    public abstract void success(T obj_pResultado);

    public abstract void failure(com.kruma.core.util.common.ProcessResult obj_pResultado);
}
