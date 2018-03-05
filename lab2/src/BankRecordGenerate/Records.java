package BankRecordGenerate;

import java.io.BufferedWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Records extends BankRecords {
	/**<h1>Bank record analysis</h1>
	 * @author Hongqiao Liu
	 * @version 1.0
	 * @since 2017-10-18
	 * @lab lab-3
	 */
	/**
	 * 
	 * this class has main method,
	 * gain data from bank-Details.csv and analyse them. In this proccess I will use AverageComparator(),
	 * MaxincomeandMinincome(),FemaleComparator(),MaleComparator(), four methods to analysing data.
	 * and use writemethod to write data to bankrecords.txt 
	 * 
	 */
	
	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		AverageComparator();
		MaxincomeandMinincome();
		FemaleComparator();
		MaleComparator();
		//current time and programmer
		System.out.println("------------------------------------------------------------------");
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
		System.out.println("current Date and Time:" + timeStamp + "\nProgrammed by Hongqiao Liu\n");
		
		String s="\r\n"+"------------------------------------------------------------------"+"\r\n"
		        +"current Date and Time:" 
				+ timeStamp 
				+ "\nProgrammed by Hongqiao Liu\n";
		writemethod("./bankrecords.txt",s);
				
	}
//method which write data to files
public static void writemethod(String file, String conent) {
 BufferedWriter out= null;
  try{
    out = new BufferedWriter(new OutputStreamWriter(
    new FileOutputStream(file, true)));
    out.write(conent+"\r\n");
     }catch(Exception e){
    e.printStackTrace();
     }finally{
	   try{
	     out.close();
          }catch(IOException e){
              e.printStackTrace();
          }
      }
}
//this method which calculate average income for every location.
private static void AverageComparator() {
	BankRecords r=new Records();
	BankRecords[] rs=r.processData();
	//use comparator to sort data.
	Arrays.sort(rs,new RegionandIncomeComparator());
	double sumT=0;
	int countT=0;
	double sumC=0;
	int countC=0;
	double sumS=0;
	int countS=0;
	double sumR=0;
	int countR=0;
	for(int i=0;i<rs.length;i++) {
		if(rs[i].getRegion().equals("TOWN")) {
			sumT+=rs[i].getIncome();
			countT++;
		}else if(rs[i].getRegion().equals("INNER_CITY")) {
			sumC+=rs[i].getIncome();
			countC++;
		}else if(rs[i].getRegion().equals("SUBURBAN")){
			sumS+=rs[i].getIncome();
			countS++;
		}else {
			sumR+=rs[i].getIncome();
			countR++;
		}
	}
	DecimalFormat df = new DecimalFormat("0.00");
	String numC =df.format((float)(sumC/countC));
	DecimalFormat df2 = new DecimalFormat("0.00");
	String numS =df2.format((float)(sumS/countS));
	DecimalFormat df3 = new DecimalFormat("0.00");
	String numT =df3.format((float)(sumT/countT));
	DecimalFormat df4 = new DecimalFormat("0.00");
	String numR =df4.format((float)(sumR/countR));
		System.out.println("Inner city region avg.income: "+numC);
		System.out.println("Town region avg.income: "+numT);
		System.out.println("SUBURBAN region avg.income"+numS);
		System.out.println("RURAL region avg.income"+numR);
		System.out.println();
		String s ="Inner city region avg.income: "+numC+";"+"\r\n"+"Town region avg.income: "+numT+";"+"\r\n"
				+"SUBURBAN region avg.income"+numS+";"+"\r\n"+"RURAL region avg.income"+numR+";"+"\r\n";
	writemethod("./bankrecords.txt",s);
}
// this method which calculate max and min income of every location.
private static void MaxincomeandMinincome() {
	
	BankRecords r=new Records();
	BankRecords[] rs=r.processData();
	
	double maxT=0;
	double maxC=0;
	double maxS=0;
	double maxR=0;
	//use comparator to sort data
	Arrays.sort(rs,new RegionandIncomeComparator());
	//calculate max income of every location
	for(int i=0;i<rs.length;i++) {
		if(rs[i].getRegion().equals("TOWN")) {
			if(rs[i].getIncome()>maxT) {
				maxT=rs[i].getIncome();
			}
		}else if(rs[i].getRegion().equals("INNER_CITY")) {
			if(rs[i].getIncome()>maxC) {
				maxC=rs[i].getIncome();
			}
			
		}else if(rs[i].getRegion().equals("SUBURBAN")){
			if(rs[i].getIncome()>maxS) {
				maxS=rs[i].getIncome();
			}
		}else {
			
			if(rs[i].getIncome()>maxR) {
				maxR=rs[i].getIncome();
			}
		}
	}
	System.out.println("Inner city region max.income: "+maxC);
	System.out.println("Town region max.income: "+maxT);
	System.out.println("SUBURBAN region max.income"+maxS);
	System.out.println("RURAL region max.income"+maxR);
	System.out.println();
	String s1="Inner city region min.income: "+maxC+";"+"\r\n"+"Town region min.income: "+maxT+";"+"\r\n"+"SUBURBAN region min.income"+maxS
			+";"+"\r\n"+"RURAL region min.income"+maxR+";"+"\r\n";
	//write data to records
	writemethod("./bankrecords.txt",s1);
	double minC=Integer.MAX_VALUE;
	double minT=Integer.MAX_VALUE;
	double minS=Integer.MAX_VALUE;
	double minR=Integer.MAX_VALUE;
	//calculate min income of every location
	for(int i=0;i<rs.length;i++) {
		if(rs[i].getRegion().equals("TOWN")) {
			if(rs[i].getIncome()<minT) {
				minT=rs[i].getIncome();
			}
		}else if(rs[i].getRegion().equals("INNER_CITY")) {
			if(rs[i].getIncome()<minC) {
				minC=rs[i].getIncome();
			}
			
		}else if(rs[i].getRegion().equals("SUBURBAN")){
			if(rs[i].getIncome()<minS) {
				minS=rs[i].getIncome();
			}
		}else {
			
			if(rs[i].getIncome()<minR) {
				minR=rs[i].getIncome();
			}
		}
	}
	System.out.println("Inner city region min.income: "+minC);
	System.out.println("Town region min.income: "+minT);
	System.out.println("SUBURBAN region min.income"+minS);
	System.out.println("RURAL region min.income"+minR);
	System.out.println();
	String s="Inner city region min.income: "+minC+";"+"\r\n"+"Town region min.income: "+minT+";"+"\r\n"+"SUBURBAN region min.income"+minS
			+";"+"\r\n"+"RURAL region min.income"+minR+";"+"\r\n";
	//write data to bankrecords.txt
	writemethod("./bankrecords.txt",s);
}
//this method calculate females with mort & saveing acct of every location
private static void FemaleComparator() {
	BankRecords r=new Records();
	BankRecords[] rs=r.processData();
	//use comparator to sort data.
	Arrays.sort(rs,new FemaleComparator());
	int countC=0;
	int countT=0;
	int countS=0;
	int countR=0;
	for(int i=0;i<rs.length;i++) {
	if(rs[i].getSex().equals("FEMALE")&& rs[i].getSave_act().equals("YES") &&rs[i].getMortgage().equals("YES")) {
		if(rs[i].getRegion().equals("TOWN")) {
			countT++;
		}else if(rs[i].getRegion().equals("INNER_CITY")) {
			countC++;
			
		}else if(rs[i].getRegion().equals("SUBURBAN")){
			countS++;
		}else {
			countR++;
		}
	}
	}
	System.out.println("Inner city region females with mort & saveing acct "+countC);
	System.out.println("Town region females with mort & saveing acct: "+countT);
	System.out.println("SUBURBAN region females with mort & saveing acct: "+countS);
	System.out.println("RURAL region females with mort & saveing acct: "+countR);
	System.out.println();
	String s="Inner city region females with mort & saveing acct "+countC+";"+"\r\n"
			+"Town region females with mort & saveing acct: "+countT+";"+"\r\n"
			+"SUBURBAN region females with mort & saveing acct: "+countS+";"+"\r\n"
			+"RURAL region females with mort & saveing acct: "+countR+";"+"\r\n";
	writemethod("./bankrecords.txt",s);
}
// this method calculate males with car and one child in every location
private static void MaleComparator() {
	BankRecords r=new Records();
	BankRecords[] rs=r.processData();
	Arrays.sort(rs,new MaleComparator());
	int countC=0;
	int countT=0;
	int countS=0;
	int countR=0;
	for(int i=0;i<rs.length;i++) {
		if(rs[i].getSex().equals("MALE")&&rs[i].getCar().equals("YES")&&rs[i].getChildren()==1) {
			if(rs[i].getRegion().equals("TOWN")) {
				countT++;
			}else if(rs[i].getRegion().equals("INNER_CITY")) {
				countC++;
				
			}else if(rs[i].getRegion().equals("SUBURBAN")){
				countS++;
			}else {
				countR++;
			}
		}
	}
	System.out.println("Inner city region males with car & 1 child: "+countC);
	System.out.println("Town region males with with car & 1 child: "+countT);
	System.out.println("SUBURBAN region males with car & 1 child: "+countS);
	System.out.println("RURAL region males with car & 1 child: "+countR);
	System.out.println();
	String s="Inner city region males with car & 1 child: "+countC+";"+"\r\n"
			+"Town region males with with car & 1 child: "+countT+";"+"\r\n"
			+"SUBURBAN region males with car & 1 child: "+countS+";"+"\r\n"
			+"RURAL region males with car & 1 child: "+countR;
	
	writemethod("./bankrecords.txt",s);
	
}
}
