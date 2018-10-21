package com.libertystudio.flickrsearch.network;

import com.libertystudio.flickrsearch.entity.MainPhotos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrService {
    String method = "?method=";
    String forJSON = "&format=json&nojsoncallback=1";

    @GET(method + "flickr.photos.search" + forJSON)
    Call<MainPhotos> getPhotosWithText(@Query("api_key") String apiKey, @Query("text") String text);
}