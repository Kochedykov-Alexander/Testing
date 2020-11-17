package itis.Handlers;

import itis.Models.MicroblogData;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XMLHandler extends DefaultHandler {

    public boolean isName, isDescription;
    private StringBuilder data;
    MicroblogData microblogData = null;
    ArrayList<MicroblogData> microblogDataList = new ArrayList<MicroblogData>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        if (qName.equals("MicroblogData")) {
            microblogData = new MicroblogData();
        }
        else if (qName.equals("Name")) {
            isName = true;
        }

        else if (qName.equals("Description")) {
            isDescription = true;
        }

        data = new StringBuilder();

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isName) {
            // age element, set Employee age
            microblogData.setName(data.toString());
            isName = false;
        } else if (isDescription) {
            microblogData.setDescription(data.toString());
            isDescription = false;
        }

        if (qName.equals("MicroblogData")) {
            // add Employee object to list
            microblogDataList.add(microblogData);
        }

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public MicroblogData getUser()
    {
        return microblogDataList.get(0);

    }
}
