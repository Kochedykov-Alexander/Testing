package itis.Helpers;

import itis.ApplicationManager;
import itis.Models.MicroblogData;
import org.openqa.selenium.By;

public class MicroblogHelper extends HelperBase {

    public MicroblogHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void addMicroblog(MicroblogData microblogData) {
        driver.findElement(By.linkText("Добавить МикроБлог")).click();
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys(microblogData.getName());
        driver.findElement(By.id("bb_textarea")).click();
        driver.findElement(By.id("bb_textarea")).sendKeys(microblogData.getDescription());
        driver.findElement(By.name("add")).click();
    }

    public void deleteMicroblog() {
        driver.findElement(By.cssSelector(".page_foot:nth-child(3) b")).click();
        driver.findElement(By.linkText("Удалить МикроБлог")).click();
        driver.findElement(By.linkText("Удалить")).click();
    }

    public MicroblogData getMicroblogDeleteData() {
        String name =  driver.findElement(By.cssSelector(".page_foot:nth-child(3) b")).getText();
        String des = driver.findElement(By.cssSelector(("#content_wrap_move > div.body > div:nth-child(3) > div > a > table > tbody > tr > td:nth-child(2) > small"))).getText();
        String [] description = des.split("\\...");

        return new MicroblogData(name, description[0]);
    }

    public MicroblogData getMicroblogData() {
        String name = driver.findElement(By.cssSelector("#content_wrap_move > div.body > div:nth-child(3) > div > a > table > tbody > tr > td:nth-child(2) > b")).getText();
        String des = driver.findElement(By.cssSelector("#content_wrap_move > div.body > div:nth-child(3) > div > a > table > tbody > tr > td:nth-child(2) > small")).getText();
        String [] description = des.split("\\...");

        return new MicroblogData(name, description[0]);
    }

}
