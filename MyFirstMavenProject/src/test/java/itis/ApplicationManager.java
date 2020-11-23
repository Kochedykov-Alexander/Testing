package itis;

import itis.Helpers.LoginHelper;
import itis.Helpers.MicroblogHelper;
import itis.Helpers.NavigationHelper;
import itis.Helpers.PhotoAlbumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    private WebDriver driver;
    private String baseURL;
    private Map<String, Object> vars;
    private JavascriptExecutor js;
    private static Settings settings = new Settings();

    private LoginHelper auth;
    private MicroblogHelper microblogHelper;
    private NavigationHelper navigationHelper;
    private PhotoAlbumHelper photoAlbumHelper;

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();

    private ApplicationManager() throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        baseURL = settings.getBaseURL();
        vars = new HashMap<String, Object>();
        auth = new LoginHelper(this);
        microblogHelper = new MicroblogHelper(this);
        photoAlbumHelper = new PhotoAlbumHelper(this);
        navigationHelper = new NavigationHelper(this, baseURL);
    }

    public void finalize() throws Throwable {
        driver.quit();
    }





    public static ApplicationManager getInstance() throws ParserConfigurationException, org.xml.sax.SAXException, IOException  {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.navigationHelper.openLoginPage();
            app.set(newInstance);
        }
        return app.get();
    }



    public LoginHelper getAuth() {
        return auth;
    }

    public void setAuth(LoginHelper auth) {
        this.auth = auth;
    }

    public MicroblogHelper getMicroblogHelper() {
        return microblogHelper;
    }

    public void setMicroblogHelper(MicroblogHelper microblogHelper) {
        this.microblogHelper = microblogHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void setNavigationHelper(NavigationHelper navigationHelper) {
        this.navigationHelper = navigationHelper;
    }

    public PhotoAlbumHelper getPhotoAlbumHelper() {
        return photoAlbumHelper;
    }

    public void setPhotoAlbumHelper(PhotoAlbumHelper photoAlbumHelper) {
        this.photoAlbumHelper = photoAlbumHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop(){
        driver.quit();
    }
}
