package BankRecordGenerate;

import java.util.Comparator;
 
public class RegionandIncomeComparator implements Comparator<BankRecords> {
	/**<h1>Bank record analysis</h1>
	 * @author Hongqiao Liu
	 * @version 1.0
	 * @since 2017-10-18
	 * @lab lab-3
	 */
	/**
	 *  this comparator has 2 level sort, sorting by region and income.
	 * */
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
