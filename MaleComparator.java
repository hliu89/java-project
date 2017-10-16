package BankRecordGenerate;

import java.util.Comparator;

public class MaleComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords a, BankRecords b) {
		// TODO Auto-generated method stub
		int res=a.getRegion().compareTo(b.getRegion());
		if(res!=0) {
			return res;
		}
		int res2=a.getSex().compareTo(b.getSex());
		if(res2!=0) {
			return res2;
		}
		int res3=a.getCar().compareTo(b.getCar());
		if(res3!=0) {
			return res3;
		}
		return (int)(a.getChildren()-b.getChildren());
	}

}
