package itis.Tests;

import org.junit.Test;

public class AddPhotoTest extends AuthBase{

    @Test
    public void addPhotoTest() {
        applicationManager.getNavigationHelper().openPhotoPage();
        applicationManager.getPhotoAlbumHelper().addPhotoAlbum(photoAlbumData);
        applicationManager.getNavigationHelper().getLogout();
    }
}
