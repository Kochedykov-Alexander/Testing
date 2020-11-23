package itis.Tests;

import itis.Models.AccountData;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class LoginTests extends TestBase {

    @Test
    public void LoginWithValidData() throws ParserConfigurationException, org.xml.sax.SAXException, IOException {

        AccountData accountData = new AccountData(settings.getLogin(), settings.getPassword());
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getAuth().login(accountData);
        AccountData accountData1 = new AccountData(accountData.getUsername());
        AccountData accountData2 = applicationManager.getNavigationHelper().getAuthData();
        Assert.assertEquals(accountData1.getUsername(), accountData2.getUsername());
        applicationManager.getNavigationHelper().getLogout();
    }

    @Test
    public void LoginWithInvalidData() throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        AccountData accountData1 = new AccountData("выывфывфвыывф", "sdfsdssddfs");
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getAuth().login(accountData1);
        applicationManager.getNavigationHelper().getLogout();


    }
}
