package com.imooc.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.imooc.entity.Car;



public class SAXParserHandler extends DefaultHandler {
	String value = "";
	Car car = null;
	private ArrayList<Car> carlist = new ArrayList<Car>();
	public ArrayList<Car> getCarList() {
		return carlist;
	}

	int carIndex = 0;
	/**
	 * 用来标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}
	
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("Car")) {
			carIndex++;

			 car=new Car();

			
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//调用DefaultHandler类的endElement方法
		super.endElement(uri, localName, qName);
		//判断是否针对一本书已经遍历结束
		if (qName.equals("Car")) {
			carlist.add(car);
			car = null;
			System.out.println("======================stop work=================");
		}
		else if (qName.equals("car_id")) {
			System.out.println(value);
			car.setId(value);
		}
		else if (qName.equals("car_type")) {
			car.setType(value);
		}
		else if (qName.equals("car_seats")) {
			car.setSeat(value);
		}
		else if (qName.equals("per_hour")) {
			car.setPer_hour(Float.parseFloat(value));
		}
		else if (qName.equals("per_week")) {
			car.setPer_week(Float.parseFloat(value));
		}
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String val="";
		val = new String(ch, start, length);
		if(!val.trim().equals("")) {
		  value=val;
		}
	}
}
