package itis.Handlers;

import itis.Models.MicroblogData;
import itis.Models.PhotoAlbumData;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XMLPhotoHandler extends DefaultHandler {

    public boolean isName, isDescription;
    private StringBuilder data;
    PhotoAlbumData photoAlbumData = null;
    ArrayList<PhotoAlbumData> photoAlbumDataArrayList = new ArrayList<PhotoAlbumData>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        if (qName.equals("PhotoAlbumData")) {
            photoAlbumData = new PhotoAlbumData();
        }
        else if (qName.equals("Name")) {
            isName = true;
        }



        data = new StringBuilder();

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isName) {
            // age element, set Employee age
            photoAlbumData.setName(data.toString());
            isName = false;
        }
        if (qName.equals("PhotoAlbumData")) {
            // add Employee object to list
            photoAlbumDataArrayList.add(photoAlbumData);
        }

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public PhotoAlbumData getPhotoAlbum()
    {
        return photoAlbumDataArrayList.get(0);

    }
}
