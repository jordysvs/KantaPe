package com.kruma.core.data.entity;
import android.database.Cursor;

import com.kruma.core.security.entity.SecurityResult;

/**
 * Created by John on 21/06/2016.
 */
public interface DataCallback<T> {

    T DetailsList(Cursor obj_pCursor);

}
