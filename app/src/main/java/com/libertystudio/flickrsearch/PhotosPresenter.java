package com.libertystudio.flickrsearch;

import android.support.v4.app.FragmentTransaction;

import com.libertystudio.flickrsearch.entity.MainPhotos;

public class PhotosPresenter {
    private PhotosFragment photosFragment;
    private PhotosInteractor photosInteractor;

    PhotosPresenter(PhotosFragment photosFragment) {
        this.photosFragment = photosFragment;
        photosInteractor = new PhotosInteractor(this::onReceived);
    }

    public void search(String title) {
        photosInteractor.loadPhotos(title);
    }

    void onPhotoClicked(String photoURL) {
        FullPhotoFragment fullPhotoFragment = new FullPhotoFragment();
        fullPhotoFragment.setUrlPhoto(photoURL);

        FragmentTransaction fragmentTransaction = photosFragment.getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction
                .replace(R.id.container, fullPhotoFragment)
                .addToBackStack(null)
                .commit();
    }

    void onReceived(MainPhotos mainPhotos) {
        photosFragment.setPhotosToRecyclerView(mainPhotos.getPhotos().getPhoto());
    }
}