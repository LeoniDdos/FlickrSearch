package com.libertystudio.flickrsearch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.libertystudio.flickrsearch.adapter.PhotoAdapter;
import com.libertystudio.flickrsearch.entity.Photo;

import java.util.List;


public class PhotosFragment extends Fragment {
    private PhotosPresenter photosPresenter;
    private PhotoAdapter photoAdapter;

    private View view;

    public PhotosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        photosPresenter = new PhotosPresenter(this);
        photoAdapter = new PhotoAdapter(getContext(), photosPresenter::onPhotoClicked);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_photos, container, false);

        init();

        return view;
    }

    private void init() {
        RecyclerView rvPhotos = view.findViewById(R.id.rvPhotos);
        rvPhotos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPhotos.setAdapter(photoAdapter);

        final EditText etTitle = view.findViewById(R.id.etSearchTitle);
        Button btnSend = view.findViewById(R.id.btnSearchSend);

        btnSend.setOnClickListener(v -> photosPresenter.search(etTitle.getText().toString()));
    }

    public void setPhotosToRecyclerView(List<Photo> photos) {
        photoAdapter.setItems(photos);
    }
}