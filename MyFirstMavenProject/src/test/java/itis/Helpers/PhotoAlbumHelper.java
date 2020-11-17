package itis.Helpers;

import itis.ApplicationManager;
import itis.Models.PhotoAlbumData;
import org.openqa.selenium.By;

public class PhotoAlbumHelper extends HelperBase {

    public PhotoAlbumHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void addPhotoAlbum(PhotoAlbumData photoAlbumData) {
        driver.findElement(By.linkText("Создать")).click();
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys(photoAlbumData.getName());
        driver.findElement(By.name("vid")).click();
        driver.findElement(By.name("vid")).click();
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.cssSelector(".iform")).click();
        driver.findElement(By.cssSelector(".submit")).click();
    }

}
