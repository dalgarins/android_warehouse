package com.maxwell.warehouse.interfaces;

/**
 * Created by Maxwell on 03/02/2016.
 */
public interface OnGenericResult<T> {
    void onSuccess(T t);
    void onError(T t);
}
