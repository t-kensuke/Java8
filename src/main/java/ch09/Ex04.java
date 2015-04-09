package ch09;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Ex04 {

	public static void main(String[] args) {

		Document document;
		try {
			document = DocumentBuilderFactory
					.newInstance()
					.newDocumentBuilder()
					.parse(new File("helloWorld.xml"));
			Node node = document.getDocumentElement();
			Node childNode = node.getFirstChild();

			System.out.println(childNode);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}

	}
}
