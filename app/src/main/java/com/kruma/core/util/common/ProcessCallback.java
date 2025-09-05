package com.kruma.core.util.common;

import com.kruma.core.security.entity.SecurityResult;

/**
 * Created by John on 21/06/2016.
 */
public abstract class ProcessCallback<T> {

    public abstract void success(T obj_pResultado);

    public abstract void failure(com.kruma.core.util.common.ProcessResult obj_pResultado);
}
