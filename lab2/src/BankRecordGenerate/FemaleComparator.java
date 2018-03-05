package BankRecordGenerate;

import java.util.Comparator;

public class FemaleComparator implements Comparator<BankRecords> {
	/**<h1>Bank record analysis</h1>
	 * @author Hongqiao Liu
	 * @version 1.0
	 * @since 2017-10-18
	 * @lab lab-3
	 */
	/**
	 * this comparator has 4 level sort, sorting by region, sex,save_act and mortgage.
	 * */
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
