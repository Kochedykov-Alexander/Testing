package itis.Tests;

import itis.Models.AccountData;
import itis.Models.MicroblogData;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static itis.Tests.AddMicroblogTestFromXml.MicroblogDataFromXmlFile;

public class AddMicroblogTest extends AuthBase {


    @Test
    public void addMicroblog() throws IOException, ParserConfigurationException, org.xml.sax.SAXException{
        applicationManager.getNavigationHelper().openMicroblogPage();
        MicroblogData microblogData = MicroblogDataFromXmlFile();
        applicationManager.getMicroblogHelper().addMicroblog(microblogData);
        applicationManager.getNavigationHelper().openMicroblogPage();
        MicroblogData microblogData1 = applicationManager.getMicroblogHelper().getMicroblogData();
        Assert.assertEquals(microblogData1.getName(), microblogData.getName());
        Assert.assertEquals(microblogData1.getDescription(), microblogData.getDescription());
    }
}
