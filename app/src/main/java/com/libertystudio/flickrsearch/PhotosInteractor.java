package com.libertystudio.flickrsearch;

import android.support.annotation.NonNull;

import com.libertystudio.flickrsearch.entity.MainPhotos;
import com.libertystudio.flickrsearch.network.FlickrService;
import com.libertystudio.flickrsearch.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosInteractor {
    private FlickrService flickrService;
    private Listener listener;

    PhotosInteractor(Listener listener) {
        flickrService = RetrofitInstance.getRetrofitInstance().create(FlickrService.class);
        this.listener = listener;
    }

    public interface Listener {
        void onReceived(MainPhotos mainPhotos);
    }

    void loadPhotos(String title) {
        Call<MainPhotos> call = flickrService.getPhotosWithText("7a99f9bd8be40c06b387e7d818e1e5bd", title);
        call.enqueue(new Callback<MainPhotos>() {
            @Override
            public void onResponse(@NonNull Call<MainPhotos> call, @NonNull Response<MainPhotos> response) {
                listener.onReceived(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<MainPhotos> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }
}