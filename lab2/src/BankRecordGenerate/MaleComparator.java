package BankRecordGenerate;

import java.util.Comparator;

public class MaleComparator implements Comparator<BankRecords> {
	/**<h1>Bank record analysis</h1>
	 * @author Hongqiao Liu
	 * @version 1.0
	 * @since 2017-10-18
	 * @lab lab-3
	 */
	/**
	 * this comparator has 4 level sort, sorting by region, sex, car and children.
	 * */
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
