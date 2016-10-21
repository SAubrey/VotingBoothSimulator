/*
 * (These are notes taken sporadically in class that don't necessarily make sense to me yet)
 * need check-in line object or list that has not been supplied
	Producer sends to check-in line.
	Object needs seconds next person, avg checkin, total time of sim, 
	avg line voter, seconds before person leaves. All previous values go into Booth
	avg seconds per voter is limited to how long they're in the booth.
	There's also a total time for entire process per voter. 
	Misleading booth queue time in instruction?
	Producer generates people, people are assigned a line, moved to booth line and then time in booth. 
	Clock controls producer and everything else. 
 * 
 * 
 */

package F16Project3StudentHelp;
import java.util.ArrayList;
/**
 * @author   Roger Ferguson
 */
public class Booth implements ClockListener {
	private ArrayList<Voter> Q = new ArrayList<Voter>();
	
	private int timeOfNextEvent = 0;
	private int maxQlength = 0;
	private Voter person;   // this is the person at the booth. 
	private int completed = 0;
	
	public void add (Voter person)
	{
		Q.add(person);
		if (Q.size() > maxQlength)
			maxQlength = Q.size();
	}
	
	public void event (int tick){
		if (tick >= timeOfNextEvent) {
			if (person != null) { 			// Notice the delay that takes place here
				person.getDestination().add(person);    // take this person to the next station. 
			person = null;				// I have send the person on. 
			}
			
			if (Q.size() >= 1) {
				person = Q.remove(0);		// do not send this person as of yet, make them wait. 
				timeOfNextEvent = tick + (int) (person.getBoothTime() + 1);
				completed++;										
			}	
		}
	}
	
	public int getLeft() {
		return Q.size();
	}
	
	public int getMaxQlength() {
		return maxQlength;
	}

	public int getThroughPut() {
		return completed;
	}
}
