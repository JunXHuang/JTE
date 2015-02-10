/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

    public static String[] ctNames = new String[180];
    public static String[][] ctLand = new String[180][180];
    public static int[] nLand = new int[180];
    public static String[][] ctSea = new String[180][180];
    public static int[] nSea = new int[180];
    private int XMLi = -1;

    public void XMLParser() {
        for (int i = 0; i < 180; i++) {
            nLand[i] = 0;
            nSea[i] = 0;
        }
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("data/cities.xml"));
            Node root = doc.getElementsByTagName("routes").item(0);
            NodeList cardlist = root.getChildNodes();
            for (int i = 0; i < cardlist.getLength(); i++) {
                Node cardNode = cardlist.item(i);
                if (cardNode.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList cardAttrs = cardNode.getChildNodes();
                    // one card
                    for (int j = 0; j < cardAttrs.getLength(); j++) {
                        if (cardAttrs.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Node theNode = cardAttrs.item(j);
                            switch (theNode.getNodeName()) {
                                case "name":
                                  //  System.out.println("City name: "
                                   //         + theNode.getTextContent());
                                    ctNames[++XMLi] = theNode.getTextContent();
                                    break;
                                case "land":
                                    NodeList landList = theNode.getChildNodes();
                                    for (int k = 0; k < landList.getLength(); k++) {
                                        if (landList.item(k).getNodeType() == Node.ELEMENT_NODE) {

                                      //     System.out.println("Land neighbour: "
                                        //            + landList.item(k)
                                         //           .getTextContent());
                                            ctLand[XMLi][k] = landList.item(k).getTextContent();
                                            nLand[XMLi] = k + 1;
                                        }
                                    }
                                    break;
                                case "sea":
                                    NodeList seaList = theNode.getChildNodes();
                                    for (int k = 0; k < seaList.getLength(); k++) {
                                        if (seaList.item(k).getNodeType() == Node.ELEMENT_NODE) {

                                       //     System.out.println("Sea neighbour: "
                                        //            + seaList.item(k)
                                         //           .getTextContent());
                                            ctSea[XMLi][k] = seaList.item(k).getTextContent();
                                            nSea[XMLi] = k + 1;
                                        }
                                    }
                                    break;
                            }
                        }
                    }

                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
