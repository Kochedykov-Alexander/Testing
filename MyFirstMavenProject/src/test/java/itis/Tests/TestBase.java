package itis.Tests;

import itis.Models.AccountData;
import itis.Models.MicroblogData;
import itis.Models.PhotoAlbumData;
import itis.ApplicationManager;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;


public class TestBase {


    AccountData accountData = new AccountData("Kochedykov00", "otumer58");
    PhotoAlbumData photoAlbumData = new PhotoAlbumData("MyPhotoTest");
    ApplicationManager applicationManager;


    @Before
    public void setUp() {
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
