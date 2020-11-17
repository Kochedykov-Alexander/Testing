package itis.Helpers;

import itis.Models.AccountData;
import itis.ApplicationManager;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(AccountData user) {
        driver.findElement(By.id("contact_s")).click();
        driver.findElement(By.id("contact_s")).sendKeys(user.getUsername());
        driver.findElement(By.id("password_s")).click();
        driver.findElement(By.id("password_s")).sendKeys(user.getPassword());
        driver.findElement(By.id("mainSubmitForm")).click();
    }
}
