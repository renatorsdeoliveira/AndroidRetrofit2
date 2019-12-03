package mobile.fasam.edu.androidretrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CommentsService {

    @POST("comments")
    Call<Comments> post(@Body Comments comments);

    @GET("comments/{id}")
    Call<Comments> get(@Path("id") Integer id);

    @GET("comments")
    Call<List<Comments>> get();

    @PUT("comments/{id}")
    Call<Comments> put(@Path("id") Integer id, @Body Comments comments);

    @PATCH("comments/{id}")
    Call<Comments> patch(@Path("id") Integer id, @Body Comments comments);

    @DELETE("comments/{id}")
    Call<Void> delete(@Path("id") Integer id);

}
