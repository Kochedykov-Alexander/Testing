package itis.Helpers;

import itis.Models.AccountData;
import itis.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class NavigationHelper extends HelperBase {

    private String baseURL;

    public NavigationHelper(ApplicationManager applicationManager, String baseURL) {
        super(applicationManager);
        this.baseURL = baseURL;
    }


    public void openLoginPage() {
        driver.get("https://foiz.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1096));
    }

    public void openMicroblogPage() {
        driver.findElement(By.cssSelector(".mmi_fave .mmi_wrap")).click();

    }

    public void getLogout() {
        driver.findElement(By.xpath("//*[@id=\"left_nav\"]/ul/div/ul/li[4]/a/span/span")).click();
        flag = false;
    }


    public void openPhotoPage() {
        driver.get("https://foiz.ru/");
        driver.manage().window().setSize(new Dimension(1357, 768));
        driver.findElement(By.linkText("Мои Фотографии")).click();

    }

    public AccountData getAuthData() {
        String name = driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[4]/table[1]/tbody/tr/td[2]/span/font")).getText();
        System.out.println(name);
        return new AccountData(name);
    }
}
