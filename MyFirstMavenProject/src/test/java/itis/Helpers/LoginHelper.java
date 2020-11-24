package itis.Helpers;

import itis.Models.AccountData;
import itis.ApplicationManager;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    NavigationHelper navigationHelper;


    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(AccountData user) {

        String expectedUrl = "https://foiz.ru/?autorized&link_id=";

        if (isLoggedIn()) {
            if (isLoggedIn(user.getUsername()))
            {
                return;
            }
            navigationHelper.getLogout();
        }

            driver.findElement(By.id("contact_s")).click();
            driver.findElement(By.id("contact_s")).sendKeys(user.getUsername());
            driver.findElement(By.id("password_s")).click();
            driver.findElement(By.id("password_s")).sendKeys(user.getPassword());
            driver.findElement(By.id("mainSubmitForm")).click();

            if (driver.getCurrentUrl().length() > expectedUrl.length() && expectedUrl.equals(driver.getCurrentUrl().substring(0, expectedUrl.length()))) {
                flag = true;
            }
    }



    public boolean isLoggedIn() {
        return flag;
    }


    public boolean isLoggedIn(String username) {
        if (driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[4]/table[1]/tbody/tr/td[2]/span/font")).getText().equals(username)) {
            return true;
        } else {
            return false;
        }
    }
}


