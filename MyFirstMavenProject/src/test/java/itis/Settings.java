package itis;

import itis.Handlers.XMLBaseUrlHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Settings {


    private static String baseURL;
    private static String login;
    private static String password;

    private static SAXParserFactory factory = SAXParserFactory.newInstance();
    private static XMLBaseUrlHandler handler = new XMLBaseUrlHandler();
    File file = new File("E:\\Testing\\MyFirstMavenProject\\src\\test\\resources\\Settings.xml");

//    public static void main(String [] args) throws ParserConfigurationException, org.xml.sax.SAXException, IOException{
//        Settings settings = new Settings();
//        System.out.println(settings.getBaseURL());
//        System.out.println(settings.getLogin());
//        System.out.println(settings.getPassword());
//    }

    public String getLogin() throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        SAXParser parser = factory.newSAXParser();
        parser.parse(file, handler);
        login = handler.getName();
        return login;
    }


    public String getPassword() throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
        SAXParser parser = factory.newSAXParser();
        parser.parse(file, handler);
        password = handler.getPassword();
        return password;
    }


        public String getBaseURL () throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, handler);
            baseURL = handler.getUrl();
            return baseURL;
        }


}
