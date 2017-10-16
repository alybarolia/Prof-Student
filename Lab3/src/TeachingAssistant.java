/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class TeachingAssistant implements Observer {
	private String name;
	private Date midterm;

	public TeachingAssistant(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void proctor(Date date){
		this.midterm = date;
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}
	
	public void postpone(Date date){
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}


	public void update(Observable arg0, Object arg1) {
		String A = (String) arg1;
		Prof p = (Prof) arg0;
		if (A.equals("Midterm Set")) {
			proctor(p.getMidterm());
		}
		if (A.equals("Midterm Postponed")) {
			postpone(p.getMidterm());
		}
		
	}
}
