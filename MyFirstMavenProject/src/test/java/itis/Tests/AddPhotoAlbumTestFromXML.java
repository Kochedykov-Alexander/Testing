package itis.Tests;


import itis.Handlers.XMLPhotoHandler;
import itis.Models.MicroblogData;
import itis.Models.PhotoAlbumData;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


public class AddPhotoAlbumTestFromXML extends TestBase {




    public static void main(String [] args) throws ParserConfigurationException, org.xml.sax.SAXException, IOException  {
        PhotoDataFromXmlFile();
    }




    public static PhotoAlbumData PhotoDataFromXmlFile() throws ParserConfigurationException, org.xml.sax.SAXException, IOException
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File file = new File("E:\\MyFirstMavenProject\\src\\test\\resources\\data.xml");
        XMLPhotoHandler handler = new XMLPhotoHandler();
        parser.parse(file, handler);
        PhotoAlbumData photoAlbumData = handler.getPhotoAlbum();




        return photoAlbumData;
    }

}









