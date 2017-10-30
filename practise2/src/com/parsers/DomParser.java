package com.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {

    public void startDomParsing(){
        try {
            System.out.println("Start DOMParse XML...\n");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("order.xml"));
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            System.out.println(root.getNodeName());
            System.out.println("============================");
            NodeList nList = root.getChildNodes();
            for (int temp = 0; temp < nList.getLength(); temp++){
                Node node = nList.item(temp);
                if(node.getNodeType() == node.ELEMENT_NODE) {
                    String nodeName = node.getNodeName();
                    Element el = (Element) node;

                    if(nodeName == "shipping"){
                        System.out.println("Shipping country: " + el.getAttribute("country"));
                        System.out.println("First name: " + el.getElementsByTagName("firstname").item(0).getTextContent());
                        System.out.println("Last name: " + el.getElementsByTagName("lastname").item(0).getTextContent());
                        System.out.println("Street: " + el.getElementsByTagName("street").item(0).getTextContent());
                        System.out.println("City: " + el.getElementsByTagName("city").item(0).getTextContent());
                        System.out.println("ZIP: " + el.getElementsByTagName("zip").item(0).getTextContent() +"\n");
                    } else if (nodeName == "bill"){
                        System.out.println("Bill country: " + el.getAttribute("country"));
                        System.out.println("First name: " + el.getElementsByTagName("firstname").item(0).getTextContent());
                        System.out.println("Last name: " + el.getElementsByTagName("lastname").item(0).getTextContent());
                        System.out.println("Street: " + el.getElementsByTagName("street").item(0).getTextContent());
                        System.out.println("City: " + el.getElementsByTagName("city").item(0).getTextContent());
                        System.out.println("ZIP: " + el.getElementsByTagName("zip").item(0).getTextContent() +"\n");
                    } else if (nodeName == "itemslist"){
                        NodeList items = doc.getElementsByTagName("item");
                        for (int i = 0; i < items.getLength(); i++) {
                            Node n = items.item(i);
                            if(n.getNodeType() == n.ELEMENT_NODE) {
                                Element e = (Element) n;
                                System.out.println("Item's id: " + e.getAttribute("id"));
                                System.out.println("Product name: " + e.getElementsByTagName("prodname").item(0).getTextContent());
                                System.out.println("Quantity: " + e.getElementsByTagName("quantity").item(0).getTextContent());
                                System.out.println("Price: " + e.getElementsByTagName("price").item(0).getTextContent());
                                System.out.println("Order date: " + e.getElementsByTagName("orderdate").item(0).getTextContent() + "\n");
                            }
                        }
                    }
                }
            }
            System.out.println("Stop parse XML...\n");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
