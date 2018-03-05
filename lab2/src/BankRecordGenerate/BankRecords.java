package BankRecordGenerate;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class BankRecords extends Client{
	/**<h1>Bank record generations</h1>
	 * @author Hongqiao Liu
	 * @version 1.0
	 * @since 2017-9-24
	 * @lab lab-2
	 */
	/**
	 * 
	 * this class has main method,
	 * Andthis class will utilize the Client three asbtract methods and generate ultimately the client records 
	 * from the csv file. this class also inclue getter and setter methods. 
	 * 
	 */
	
	/** id {string} 
    age {numeric}
    sex {FEMALE,MALE}
    region {INNER_CITY,TOWN,RURAL,SUBURBAN}
    income {numeric}
    married {NO,YES}
    children {0,1,2,3}
    car {NO,YES}
    save_act {NO,YES}
    current_act {NO,YES}
    mortgage {NO,YES}
    pep {YES,NO}**/

	private String id;
	private int age;
	private String sex;
	private String region;
	private double income;
	private String married;
	private int children;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;
	
	//getter and setter function
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getSave_act() {
		return save_act;
	}
	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}
	public String getCurrent_act() {
		return current_act;
	}
	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}
	public String getMortgage() {
		return mortgage;
	}
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}
	public String getPep() {
		return pep;
	}
	public void setPep(String pep) {
		this.pep = pep;
	}
	
	//readData function, which can get information from file.
	@Override
	public ArrayList<List<String>> readData() {
		// TODO Auto-generated method stub
		ArrayList<List<String>> list=new ArrayList<List<String>>();
		
		try {
		//FileInputStream fis= new FileInputStream("C:\\Users\\SAN2271\\Desktop\\ITMD510\\lab2\\bank-Detail.csv");
		FileInputStream fis= new FileInputStream("./bank-Detail.csv");
		InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);  
        String line = null;
        //int i=0;
        while((line=br.readLine())!=null){
        	//System.out.println(line);
        	List<String> list2=new ArrayList<String>();
        	String [] liner=line.split(",");
			for(String s:liner) {
				list2.add(s);
			}
			list.add(list2);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("there is a problem loading the file");
	}
		
		return list;
		
	}

	
	//printData function can print information which get from processData function
	@Override
	public void printData() {
		// TODO Auto-generated method stub
		//ArrayList<BankRecords> listC=new ArrayList<BankRecords>();
		BankRecords[] listC;
		BankRecords s=new BankRecords();
		listC=s.processData();
		for(int j=0;j<listC.length;j++) {
			
		}
		for(int i=0;i<26;i++) {
			
			//BankRecords c=new BankRecords();
			//ID, AGE, SEX, REGION, INCOME, and MORTGAGE
			if(i==0) {
				System.out.printf("%10s%5s%10s%15s%10s%12s","ID","AGE","SEX","REGION","INCOME"
						,"MORTGAGE"+"\n");
			}else {
				BankRecords c=listC[i-1];
			System.out.printf("%10s%5s%10s%15s%10s%12s",c.getId(),c.getAge(),c.getSex(),c.getRegion(),c.getIncome()
					,c.getMortgage()+"\n");
			}
		}
		
	}
	
	//processData function,receive data from readData function, and change them to a Array,
	//and then printData function will receive them. 
	@Override
	public BankRecords[] processData() {
		// TODO Auto-generated method stub
		//List<String> list2;
		ArrayList<List<String>> list=new ArrayList<List<String>>();
		//ArrayList<BankRecords> listC=new ArrayList<BankRecords>();
		
	BankRecords s=new BankRecords();
	list=s.readData();
	BankRecords[] recordslist=new BankRecords[list.size()];
	for(int j=0;j<list.size();j++) {
		List<String> l=list.get(j);
		BankRecords c=new BankRecords();
		for(int i=0;i<l.size();i++) {
			switch(0) {  
			case 0:
				c.setId(l.get(0));
			case 1:
				c.setAge(Integer.parseInt(l.get(1)));
			case 2:
				c.setSex(l.get(2));
			case 3:
				c.setRegion(l.get(3));
			case 4:
				c.setIncome((Double.parseDouble(l.get(4))));
			case 5:
				c.setMarried(l.get(5));
			case 6:
				c.setChildren(Integer.parseInt(l.get(6)));
			case 7:
				c.setCar(l.get(7));
			case 8:
				c.setSave_act(l.get(8));
			case 9:
				c.setCurrent_act(l.get(9));
			case 10:
				c.setMortgage(l.get(10));
				
			case 11:
				c.setPep(l.get(11));
			}
		}
		recordslist[j]=c;
	}
	return recordslist;
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		BankRecords s=new BankRecords();
		s.printData();

		//current time and programmer
		System.out.println("------------------------------------------------------------------");
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
		System.out.println("current Date and Time:" + timeStamp + "\nProgrammed by Hongqiao Liu\n");

}

} 
