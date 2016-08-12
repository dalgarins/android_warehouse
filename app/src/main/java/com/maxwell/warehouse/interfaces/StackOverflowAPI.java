package com.maxwell.warehouse.interfaces;

import com.maxwell.warehouse.models.StackOverflowQuestions;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Maxwell on 12/08/2016.
 */
public interface StackOverflowAPI {
    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverflowQuestions> loadQuestions(@Query("tagged") String tags);
}
