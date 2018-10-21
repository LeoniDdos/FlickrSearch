package com.libertystudio.flickrsearch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class FullPhotoFragment extends Fragment {
    private String urlPhoto;

    public FullPhotoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_photo, container, false);

        openFullPicture(view);

        return view;
    }

    public void openFullPicture(View view) {
        ImageView ivFullPhoto = view.findViewById(R.id.ivFullPhoto);
        Glide
                .with(this)
                .load(urlPhoto)
                .into(ivFullPhoto);
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}