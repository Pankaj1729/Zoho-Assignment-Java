// import java.util.Scanner;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
// import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlParsing {

    public void createXMLDoc(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("file1.xml"));
        transformer.transform(source, result);
    }

    public static void main(String[] args) throws TransformerException, SAXException, IOException {
        XmlParsing obj = new XmlParsing();

        try {
            DocumentBuilderFactory doFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder doBuilder = doFactory.newDocumentBuilder();

            // root Element
            Document doc = doBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            // create other Element node

            Element emp = doc.createElement("Employee");
            rootElement.appendChild(emp);
            emp.setAttribute("id", "123");

            // Details add
            Element name = doc.createElement("Name");
            name.setTextContent("Pankaj");
            emp.appendChild(name);

            Element role = doc.createElement("Role");
            role.setTextContent("MTS-1");
            emp.appendChild(role);

            obj.createXMLDoc(doc);

            // read file

            // to process xml securely.(It is optional)
            doFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML File
            Document doc1 = doBuilder.parse(new File("file1.xml"));
            doc1.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc1.getDocumentElement().getNodeName());
            System.out.println("------");

            NodeList list = doc.getElementsByTagName("Employee");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element ele = (Element) node;

                    // get Employee attribute

                    String id = ele.getAttribute("id");

                    String empName = ele.getElementsByTagName("Name").item(0).getTextContent();
                    String empRole = ele.getElementsByTagName("Role").item(0).getTextContent();

                    System.out.println("Current Element :" + node.getNodeName());
                    System.out.println("Employee Id : " + id);
                    System.out.println("Employee Name : " + empName);
                    System.out.println("Employee Role : " + empRole);

                }

            }

        } catch (ParserConfigurationException | IOException p) {
            p.getStackTrace();
        }

    }
}
