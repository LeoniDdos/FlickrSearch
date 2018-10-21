package com.libertystudio.flickrsearch;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;

/**
 * Unit-tests for PhotosPresenter
 */
public class PhotosPresenterUnitTest {
    private PhotosFragment photosFragment;

    @Before
    public void setUp() {
        photosFragment = new PhotosFragment();
    }

    @Test
    public void creation_isCorrect() {
        PhotosPresenter photosPresenter = new PhotosPresenter(photosFragment);
        assertNotNull(photosPresenter);
    }

    @Test
    public void interactor_isExists() {
        PhotosPresenter photosPresenter = new PhotosPresenter(photosFragment);
        photosPresenter.search("test");
    }

    @Test (expected=NullPointerException.class)
    public void title_isEmpty() throws NullPointerException{
        PhotosPresenter photosPresenter = new PhotosPresenter(photosFragment);
        photosPresenter.search("");

        Mockito.verify(photosFragment).showTitleError();
    }
}