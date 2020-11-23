package itis.Tests;


import itis.Models.AccountData;
import itis.Models.PhotoAlbumData;
import itis.ApplicationManager;
import itis.Settings;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class TestBase {

    static Settings settings = new Settings();
    static ApplicationManager applicationManager;
    PhotoAlbumData photoAlbumData = new PhotoAlbumData("MyPhotoTest");



    @Before
    public void setUp() throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        applicationManager = ApplicationManager.getInstance();

    }

   @AfterAll
    public void tearDown() throws Throwable {
        applicationManager.finalize();

    }

    public static String generateRandomString(int n) {

        String alphaNumberString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        //int n = (int) (Math.random() * 10);
        StringBuffer stringBuffer = new StringBuffer(n);


        for (int i = 0; i < n; i++) {
            int index = (int)(alphaNumberString.length() * Math.random());
            System.out.println(index);
            stringBuffer.append(alphaNumberString.charAt(index));
        }
        return stringBuffer.toString();
    }



}
