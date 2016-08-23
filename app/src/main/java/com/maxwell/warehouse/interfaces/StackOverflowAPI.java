package com.maxwell.warehouse.interfaces;

import com.maxwell.warehouse.models.stackoverflow.Answer;
import com.maxwell.warehouse.models.stackoverflow.Badges;
import com.maxwell.warehouse.models.stackoverflow.Comment;
import com.maxwell.warehouse.models.stackoverflow.Items;
import com.maxwell.warehouse.models.stackoverflow.Question;
import com.maxwell.warehouse.models.stackoverflow.Tag;
import com.maxwell.warehouse.models.stackoverflow.TagScore;
import com.maxwell.warehouse.models.stackoverflow.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Maxwell on 12/08/2016.
 */
public interface StackOverflowAPI {
    // Questions
    @GET("questions?order=desc&sort=activity&site=stackoverflow&filter=!9YdnSIN18")
    Call<Items<Question>> loadAllQuestions(@Query("sort") String sort);

    @GET("questions?order=desc&site=stackoverflow&filter=!-*f(6rc.lFba")
    Call<Items<Question>> loadQuestionsByTag(@Query("tagged") String tags, @Query("sort") String sort);

    @GET("questions/{id}/answers?order=desc&sort=activity&site=stackoverflow&filter=!b0OfN.wYmA0RcX")
    Call<Items<Answer>> loadAnswersFromQuestion(@Path("id") int id);

    @GET("questions/{id}/comments?order=desc&sort=activity&site=stackoverflow")
    Call<Items<Comment>> loadCommentsFromQuestion(@Path("id") int id);

    // Tags
    @GET("tags?order=desc&sort=popular&site=stackoverflow")
    Call<Items<Tag>> loadPopularTags();

    @GET("tags/{tag}/top-askers/all_time?site=stackoverflow")
    Call<Items<TagScore>> loadTopAskersByTag(@Path("tag") String tag);

    @GET("tags/{tag}/top-answerers/all_time?site=stackoverflow")
    Call<Items<TagScore>> loadTopAnswerersByTag(@Path("tag") String tag);

    //Users
    @GET("users?order=desc&sort=reputation&site=stackoverflow")
    Call<Items<User>> loadUsersByReputation();

    @GET("users/{id}/answers?order=desc&sort=activity&site=stackoverflow")
    Call<Items<Answer>> loadAnsersFromUserId(@Path("id") int id);

    @GET("users/{id}/badges?order=desc&sort=rank&site=stackoverflow")
    Call<Items<Badges>> loadBadgesFromUserId(@Path("id") int id);

    @GET("users/{id}/comments?order=desc&sort=creation&site=stackoverflow")
    Call<Items<Comment>> loadCommentsFromUserId(@Path("id") int id);

    @GET("users/{id}/tags?order=desc&sort=popular&site=stackoverflow")
    Call<Items<Tag>> loadTagsFormUserId(@Path("id") int id);

    // Misc
    @GET("badges?order=desc&sort=rank&site=stackoverflow")
    Call<Items<Badges>> loadBadges();

    @GET("search?order=desc&sort=activity&site=stackoverflow&filter=!-*f(6rc.lFba")
    Call<Items<Question>> loadSearchQuestions(@Query("intitle") String intitle);
}
