
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Use JAXP DOM Parser to display all persons: title, names...
 * 
 * @author Huseyin OZVEREN
 */
public class Test {

	public static void main(String[] args) throws Exception {

		// Create a DOM parser factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// Obtain a DOM builder
		DocumentBuilder docBuilder = factory.newDocumentBuilder();

		// XML Stream
		InputStream xmlStream = Test.class.getResourceAsStream("people.xml");
		
		// Parse the given XML document 
		// in order to build a DOM tree representing the XML document
		Document doc = docBuilder.parse(xmlStream);

		// Return all the person elements as NodeList
		//NodeList personNodes = doc.getElementsByTagName("person"); 
		// Return the root element
		//Element root = doc.getDocumentElement();  

		// Get a list of all elements in the document
		// The wild card * matches all tags
		NodeList list = doc.getElementsByTagName("*");

		int peopleCount = 0;
		for (int i = 0; i < list.getLength(); i++) {
			
			// Get the elements person (attribute ID), title, names...
			Element element = (Element) list.item(i);
			String nodeName = element.getNodeName();
			
			if (nodeName.equals("User")) {
				peopleCount++;
				System.out.println("User " + peopleCount);
				String personId = element.getAttribute("ID");
				System.out.println("\tID:\t" + personId);
			
			} else if (nodeName.equals("name")) {
				System.out.println("\tName:\t" + element.getChildNodes().item(0).getNodeValue());
                        }else if (nodeName.equals("friend")) {
				System.out.println("\tFriend:\t" + element.getChildNodes().item(0).getNodeValue());
        
                                
			} else if (nodeName.equals("born")) {
				System.out.println("\tborn:\t" + element.getChildNodes().item(0).getNodeValue());
			}
                        else if (nodeName.equals("address")) {
				System.out.println("\taddress:\t" + element.getChildNodes().item(0).getNodeValue());
			}
                      else if (nodeName.equals("nationality")) {
				System.out.println("\tnationality:\t" + element.getChildNodes().item(0).getNodeValue());
			}  
                        else if (nodeName.equals("tel")) {
				System.out.println("\ttel:\t" + element.getChildNodes().item(0).getNodeValue());
			}   
		} // end-for
	}
	
}