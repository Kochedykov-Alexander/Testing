import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class CuttedGenerator {


    public static void main(String [] args) {


        ;
        String file = "data";
        String format = "xml";
        String type = "microblog";


        String filename = "E:\\MyFirstMavenProject\\src\\test\\resources\\" + file + "." + format ;



        if (type == "microblog")
        {
            generateForMicroblog(filename, format);
        }

        else if (type == "photo") {
            generateForPhoto(filename, format);
        }
        else
        {
            System.out.println("Unrecognized type of data" + type);
        }


    }

    public static void generateForMicroblog(String filename, String format) {




        if (format == "xml") {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                //root elements
                Document document = docBuilder.newDocument();

                // Вызываем метод для добавления новой книги
                addNewMicroblog(document);
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace(System.out);
            }

        }
    }

    public static void addNewMicroblog(Document document) throws TransformerFactoryConfigurationError, DOMException {

        Element rootElement = document.createElement("MicroblogDataOfArray");
        document.appendChild(rootElement);

        // Создаем новую книгу по элементам
        // Сама книга <Book>
        Element book = document.createElement("MicroblogData");
        // <Title>
        Element name = document.createElement("Name");
        name.setTextContent(generateRandomString(10));


        Element description = document.createElement("Description");
        description.setTextContent(generateRandomString(10));


        book.appendChild(name);
        book.appendChild(description);
        rootElement.appendChild(book);

        // Записываем XML в файл
        writeDocument(document);
    }

    public static void generateForPhoto(String filename, String format) {




        if (format == "xml") {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                //root elements
                Document document = docBuilder.newDocument();

                // Вызываем метод для добавления новой книги
                addNewPhoto(document);
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace(System.out);
            }

        }
    }

    public static void addNewPhoto(Document document) throws TransformerFactoryConfigurationError, DOMException {

        Element rootElement = document.createElement("ArrayOfPhotoData");
        document.appendChild(rootElement);

        Element book = document.createElement("PhotoAlbumData");

        // Создаем новую книгу по элементам
        // Сама книга <Book>
        Element name = document.createElement("Name");
        name.setTextContent(generateRandomString(10));





        book.appendChild(name);
        rootElement.appendChild(book);

        // Записываем XML в файл
        writeDocument(document);
    }

    // Функция для сохранения DOM в файл
    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("E:\\MyFirstMavenProject\\src\\test\\resources\\data.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomString(int n) {

        String alphaNumberString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        //int n = (int) (Math.random() * 10);
        StringBuffer stringBuffer = new StringBuffer(n);


        for (int i = 0; i < n; i++) {
            int index = (int)(alphaNumberString.length() * Math.random());
            //System.out.println(index);
            stringBuffer.append(alphaNumberString.charAt(index));
        }
        return stringBuffer.toString();
    }

}

