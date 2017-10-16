package BankRecordGenerate;

import java.util.Comparator;

public class FemaleComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		// TODO Auto-generated method stub
		int res1=o1.getRegion().compareTo(o2.getRegion());
		if(res1!=0) {
			return res1;
		}
		int res=o1.getSex().compareTo(o2.getSex());
		if(res!=0) {
		return res;	
		}
		int sav=o1.getSave_act().compareTo(o2.getSave_act());
		if(sav!=0) {
			return sav;
		}
		return o1.getMortgage().compareTo(o2.getMortgage());
	}

}
