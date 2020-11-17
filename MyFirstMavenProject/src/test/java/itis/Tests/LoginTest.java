package itis.Tests;

import itis.Models.AccountData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends TestBase {


    @Test
    public void loginAuth() {
        applicationManager.getNavigationHelper().getLogout();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getAuth().login(accountData);
        AccountData accountData1 = new AccountData(accountData.getUsername());
        AccountData accountData2 = applicationManager.getNavigationHelper().getAuthData();
        Assert.assertEquals(accountData1.getUsername(), accountData2.getUsername());
    }

}
