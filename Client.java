package BankRecordGenerate;


import java.util.ArrayList;
import java.util.List;

public abstract class Client {
	/**<h1>Bank record generations</h1>
	 * @author Hongqiao Liu
	 * @version 1.0
	 * @since 2017-9-24
	 * @lab lab-2
	 */
	public abstract ArrayList<List<String>> readData();
	public abstract void printData();
	public abstract BankRecords[] processData();
	
}
