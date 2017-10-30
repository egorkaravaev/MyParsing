package com.parsers;

import com.order.Bill;
import com.order.Item;
import com.order.Shipping;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SaxParser extends DefaultHandler{

    Shipping shipping = new Shipping();
    Bill bill = new Bill();
    Item item;
    ArrayList<Item> itemsList = new ArrayList<>();

    private String thisElement = "";
    private String thisAttribute = "";
    private String thisAttributeValue = "";
    private boolean isShipping = true;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start SAXParse XML...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
        System.out.println("Start element : " + thisElement);
        for (int att = 0; att < attributes.getLength(); att++) {
            thisAttribute = attributes.getQName(att);
            thisAttributeValue = attributes.getValue(thisAttribute);
            System.out.println(thisAttribute + " = " + thisAttributeValue);
        }
        if(thisElement.equals("bill")){
            isShipping = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(thisElement.equals("shipping")) {
            shipping.setCountry(thisAttributeValue);
        } else if(thisElement.equals("bill")){
            bill.setCountry(thisAttributeValue);
        }
        if(thisElement.equals("firstname") & isShipping == true){
            shipping.setFirstName(new String(ch, start, length));
        } else if(thisElement.equals("firstname") & isShipping == false){
            bill.setFirstName(new String(ch, start, length));
        }
        if(thisElement.equals("lastname") & isShipping == true){
            shipping.setLastName(new String(ch, start, length));
        } else if(thisElement.equals("lastname") & isShipping == false){
            bill.setLastName(new String(ch, start, length));
        }
        if(thisElement.equals("street") & isShipping == true){
            shipping.setStreet(new String(ch, start, length));
        } else if(thisElement.equals("street") & isShipping == false){
            bill.setStreet(new String(ch, start, length));
        }
        if(thisElement.equals("city") & isShipping == true){
            shipping.setCity(new String(ch, start, length));
        } else if(thisElement.equals("city") & isShipping == false){
            bill.setCity(new String(ch, start, length));
        }
        if(thisElement.equals("zip") & isShipping == true){
            shipping.setZip(new Integer(new String(ch, start, length)));
        } else if(thisElement.equals("zip") & isShipping == false){
            bill.setZip(new Integer(new String(ch, start, length)));
        }
        if(thisElement.equals("item")){
            item = new Item();
            item.setId(Integer.valueOf(thisAttributeValue));
        }
        if(thisElement.equals("prodname")) {
            item.setProdName(new String(ch, start, length));
        }
        if(thisElement.equals("quantity")) {
            item.setQuantity(new Integer(new String(ch, start, length)));
        }
        if(thisElement.equals("price")) {
            item.setPrice(new Integer(new String(ch, start, length)));
        }
        if(thisElement.equals("orderdate")) {
            item.setOrderdate(new String(ch, start, length));
            itemsList.add(item);
        }
        

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element : " + thisElement);
        thisElement = "";
        thisAttribute = "";
        thisAttributeValue = "";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Stop parse XML...");
        showOrder();
    }

    private void showOrder() {
        System.out.println(shipping.toString());
        System.out.println(bill.toString());
        for (Item i: itemsList) {
            System.out.println(i.toString());
        }
    }


}
