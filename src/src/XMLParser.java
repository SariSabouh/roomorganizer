package src;

import java.io.*;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler
{
	private String tmpName;
	private String tmpValue;
	private boolean tagCheck;
	public ArrayList<Student> students = new ArrayList<Student>();
	public ArrayList<Room> rooms = new ArrayList<Room>();

	public XMLParser(String filename)
	{	
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try{
			SAXParser parser = factory.newSAXParser();
			parser.parse(filename, this);
		}catch (ParserConfigurationException e) {
			System.out.println("ParserConfig error");
		} catch (SAXException e) {
			System.out.println("SAXException : xml not well formed");
		} catch (IOException e) {
			System.out.println("IO error");
		}
	}

	public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
        
		if (elementName.equalsIgnoreCase("student")) tagCheck = true;
		else if (elementName.equalsIgnoreCase("room")) tagCheck = false;
    }

	@Override
    public void endElement(String s, String s1, String element) throws SAXException {
		if (tagCheck)
		{
			Student ss = new Student();
			if (element.equalsIgnoreCase("fullName")) {
				ss.setName(tmpValue);
			}
			else if (element.equalsIgnoreCase("year")){
				ss.setYear(tmpValue);
			}
			if (element.equalsIgnoreCase("country")){
				ss.setCountry(tmpValue);
			}
			if (element.equalsIgnoreCase("sharedBathroom")){
				ss.setBathroom(Boolean.parseBoolean(tmpValue));
			}
			if (element.equalsIgnoreCase("gender")){
				ss.setSex(tmpValue);
			}
			students.add(ss);
		}
		else
		{
			if (element.equalsIgnoreCase("roomNumber")) {
				tmpName = tmpValue;
			}			
			if (element.equalsIgnoreCase("shared")){
				rooms.add(new Room(tmpName, Boolean.parseBoolean(tmpValue)));
			}
			
		}
		
    }

	@Override
    public void characters(char[] ac, int i, int j) throws SAXException {
        tmpValue = new String(ac, i, j);
    }
}