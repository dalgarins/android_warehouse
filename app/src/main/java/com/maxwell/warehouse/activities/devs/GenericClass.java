package com.maxwell.warehouse.activities.devs;

/**
 * Created by Maxwell on 03/02/2016.
 */
public class GenericClass<T>{
    public String getTheClass(T t) {
        return t.getClass().getName();
    }
}
