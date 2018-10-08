package com.netlink.xml.parser;

//importing xml realted packages

import org.w3c.dom.*;					 //NodeList,Node,Document
import javax.xml.parsers.*;				// DocumentBuilderFactory and DocumentBuilder methods
import java.io.*;		 			   //File Object

public class XmlParser

{
	public static void main(String args[])throws Exception
	{
		//creating Document Builder
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=dbf.newDocumentBuilder();

		//create a document from file
		Document doc=builder.parse(new File("..//xmlparser//xml//input.xml"));

		//Extracting root element
		Element root=doc.getDocumentElement();
		System.out.println("root element:"+root.getNodeName());

		//Get all students
		NodeList list=doc.getElementsByTagName("student");
		System.out.println();

		for(int i=0;i<list.getLength();i++)
		{
			Node node=list.item(i);
			if(node.getNodeType()==Node.ELEMENT_NODE)
			{
				Element e=(Element)node;
				System.out.println("Student rollno:"+e.getAttribute("rollno"));
				System.out.println("First Name : "  + e.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name : "   + e.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Nick Name : "    + e.getElementsByTagName("nickname").item(0).getTextContent());
				System.out.println("Marks : "  + e.getElementsByTagName("marks").item(0).getTextContent());
			}

		}
	}
}
