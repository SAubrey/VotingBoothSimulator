package F16Project3StudentHelp;

import java.util.ArrayList;
import java.util.Random;

public class CheckIn extends Booth{
	private ArrayList<Voter> Q = new ArrayList<Voter>();
	
	private int maxQ = 0;
	private int timeNextEvent = 0;
	private Voter person;
	private int completed = 0;
	Random rand = new Random();
	
	public void add(Voter person){
		Q.add(person);
		if(Q.size() > maxQ){
			maxQ = Q.size();
		}
	}
	
	public void event(int tick){
		if(tick >= timeNextEvent){
			if(person != null){
				person.getDestination().add(person);
				person = null;
			}
			if(Q.size() >= 1){
				person = Q.remove(0);
				timeNextEvent = tick + (int) (person.getCheckInTime() + 1);
				completed++;
			}
		}
	}
	
	public int getLeft() {
		return Q.size();
	}
	
	public int getMaxQlength() {
		return maxQ;
	}

	public int getThroughPut() {
		return completed;
	}
}
