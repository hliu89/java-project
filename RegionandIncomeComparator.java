package BankRecordGenerate;

import java.util.Comparator;
 
public class RegionandIncomeComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords a, BankRecords b) {
		// TODO Auto-generated method stub
		int res=a.getRegion().compareTo(b.getRegion());
		if(res!=0) {
			return res;
		}
		return (int)(a.getIncome()-b.getIncome());
	}

}
