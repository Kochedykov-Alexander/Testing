package itis.Tests;

import itis.ApplicationManager;
import itis.Models.AccountData;
import itis.Models.PhotoAlbumData;
import itis.Settings;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class AuthBase extends TestBase{

    TestBase testBase = new TestBase();





    @Before
    public void setUp() throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        testBase.setUp();
        AccountData accountData = new AccountData(settings.getLogin(), settings.getPassword());
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getAuth().login(accountData);


    }
}
