package itis.Handlers;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class XMLBaseUrlHandler extends DefaultHandler {

    public boolean flagUrl,flagName,flagPassword = false;
    private StringBuilder data;
    String url, name, password = null;



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        if (qName.equals("Url")) {
            flagUrl = true;
        }
        else if (qName.equals("Login")) {
            flagName = true;
        }
        else if (qName.equals("Password")) {
            flagPassword = true;
        }

        data = new StringBuilder();

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (flagUrl) {
            url = data.toString();
            flagUrl = false;
        }
        else if (flagName) {
            name = data.toString();
            flagName = false;
        }
        else if (flagPassword) {
            password = data.toString();
            flagPassword = false;
        }

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public String getUrl()
    {
        return url;

    }

    public String getName()
    {
        return name;

    }

    public String getPassword()
    {
        return password;

    }

}