package com.maxwell.warehouse.interfaces;

/**
 * Created by Maxwell on 03/02/2016.
 */
public interface OnGenericRestrictResult<String> {
    void onSuccess(String s);
    void onError(String s);
}
