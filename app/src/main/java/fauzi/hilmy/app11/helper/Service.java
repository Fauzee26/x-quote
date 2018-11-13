package fauzi.hilmy.app11.helper;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 26FaUZeE02 on 4/26/18.
 */

public interface Service {

    @GET("/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=1")
    Call<JsonArray> readQuoteArray();
}
