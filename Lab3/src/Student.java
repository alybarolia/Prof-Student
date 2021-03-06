/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Student implements Observer{
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + date);
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + date);
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		String A = (String) arg1;
		Prof p = (Prof) arg0;
		if (A.equals("Midterm Set")) {
			study(p.getMidterm());
		}
		if (A.equals("Midterm Postponed")) {
			party(p.getMidterm());
		}
		
	}
}
