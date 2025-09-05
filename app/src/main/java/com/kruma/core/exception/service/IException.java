package com.kruma.core.exception.service;

import com.kruma.core.exception.entity.*;
import com.kruma.core.security.entity.SecurityResult;
import com.kruma.core.service.entity.ServiceResult;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by John on 27/06/2016.
 */
public interface IException {

    @POST("/HandlerException")
    public void HandleException(
            @Path("Exception") com.kruma.core.exception.entity.Exception obj_pException,
            @Path("PolicyName")String str_pPolicyName,
            Callback<ServiceResult<Boolean>> obj_pCallback
            );
}
