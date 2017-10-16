package BankRecordGenerate;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Records extends BankRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		AverageComparator();
		MaxincomeandMinincome();
		FemaleComparator();
		MaleComparator();
	}

private static void AverageComparator() {
	BankRecords r=new Records();
	BankRecords[] rs=r.processData();
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
	
}
private static void MaxincomeandMinincome() {
	
	BankRecords r=new Records();
	BankRecords[] rs=r.processData();
	
	double maxT=0;
	double maxC=0;
	double maxS=0;
	double maxR=0;
	Arrays.sort(rs,new RegionandIncomeComparator());
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
	double minC=Integer.MAX_VALUE;
	double minT=Integer.MAX_VALUE;
	double minS=Integer.MAX_VALUE;
	double minR=Integer.MAX_VALUE;
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
}

private static void FemaleComparator() {
	BankRecords r=new Records();
	BankRecords[] rs=r.processData();
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
}
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
}
}
