package cn.edu.gdmec.s07131020.demo_dom;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMXMLParser {
   public static List<User> parse(InputStream in){
	   List<User> users = null;
	   
	   try {
		   users=new ArrayList<User>();
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		   DocumentBuilder builder =factory.newDocumentBuilder();
		   Document document=builder.parse(in);
			
		   
		   Element root=document.getDocumentElement();
	
		   NodeList nodeList=root.getElementsByTagName("user");
		   
		   for(int i=0;i<nodeList.getLength();i++){
			   Node node=nodeList.item(i);
			   Element element=(Element) node;
			   User user =new User();
			   user.setId(Integer.parseInt(element.getAttribute("id")));
		 
			   NodeList childNodes=node.getChildNodes();
			   
			   for(int j=0;j<childNodes.getLength();j++){
				   Node childNode=childNodes.item(j);
				   if(childNode.getNodeType()==Node.ELEMENT_NODE){
					   Element e=(Element) childNode;
					  
					   if(childNode.getNodeName().equals("name")){
						 user.setName(childNode.getFirstChild().getNodeValue());
					   }
					   
					   if(e.getNodeName().equals("password")){
						   user.setPassword(childNode.getFirstChild().getNodeValue());
					   }
				   }
			   }
			   users.add(user);
		   }
	   } catch (ParserConfigurationException e) {
		e.printStackTrace();
	} catch (SAXException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   
	   return users;
   }
   
}
