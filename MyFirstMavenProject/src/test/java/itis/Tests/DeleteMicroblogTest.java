package itis.Tests;

import itis.Models.MicroblogData;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static itis.Tests.AddMicroblogTestFromXml.MicroblogDataFromXmlFile;

public class DeleteMicroblogTest extends AuthBase{

    @Test
    public void deleteMicroblog() throws ParserConfigurationException, org.xml.sax.SAXException, IOException {

        applicationManager.getNavigationHelper().openMicroblogPage();
        MicroblogData microblogData = MicroblogDataFromXmlFile();
        MicroblogData microblog = applicationManager.getMicroblogHelper().getMicroblogDeleteData();
        applicationManager.getMicroblogHelper().deleteMicroblog();
        applicationManager.getNavigationHelper().getLogout();
        Assert.assertEquals(microblogData.getName(), microblog.getName());
        Assert.assertEquals(microblogData.getDescription(), microblog.getDescription());
    }
}
