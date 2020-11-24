package itis.Helpers;

import itis.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected WebDriver driver;
    protected ApplicationManager applicationManager;
    static boolean flag = false;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }
}
