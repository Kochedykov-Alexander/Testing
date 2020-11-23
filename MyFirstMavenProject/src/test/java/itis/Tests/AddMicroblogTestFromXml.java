package itis.Tests;


import itis.Handlers.XMLHandler;
import itis.Models.MicroblogData;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


public class AddMicroblogTestFromXml {




    public static void main(String [] args) throws ParserConfigurationException, org.xml.sax.SAXException, IOException  {
        MicroblogDataFromXmlFile();
    }


    //Метод который вам нужен чтобы распарсить Xml

    public static MicroblogData MicroblogDataFromXmlFile() throws ParserConfigurationException, org.xml.sax.SAXException, IOException
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File file = new File("E:\\Testing\\MyFirstMavenProject\\src\\test\\resources\\data.xml");
        XMLHandler handler = new XMLHandler();
        parser.parse(file, handler);
        MicroblogData microblogData = handler.getUser();

        System.out.println(String.format("Имя сотрудника: %s, его должность: %s", microblogData.getName(), microblogData.getDescription()));


        return microblogData;
    }

}









