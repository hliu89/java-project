package com.imooc.test;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


import com.imooc.entity.Car;
import com.imooc.handler.Dao;
import com.imooc.handler.SAXParserHandler;



public class SAXTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		Dao d=new Dao();

		try {
			SAXParser parser = factory.newSAXParser();

			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("CarData.xml", handler);
			List<Car> carl=handler.getCarList();
			for (int i=0;i<carl.size();i++) {
				
			    	d.insertCar(carl.get(i).getId(), carl.get(i).getType(), carl.get(i).getSeat(), carl.get(i).getPer_hour(), carl.get(i).getPer_week());
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
