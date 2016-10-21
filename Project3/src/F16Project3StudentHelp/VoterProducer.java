/**
 * 
 */
package F16Project3StudentHelp;

import java.util.Random;

/**
 * @author Roger Ferguson
 */
public class VoterProducer implements ClockListener {
	
	private int nextPerson = 0;
	private Booth booth;
	private int numOfTicksNextPerson;
	private int averageBoothTime;
	private int avgCheckInTime;
	
	private Random r = new Random();
	
	public VoterProducer(Booth b, 
			int numOfTicksNextPerson, 
			int averageBoothTime,
			int checkInTime) {
		
		this.booth = b;
		this.numOfTicksNextPerson = numOfTicksNextPerson;
		this.averageBoothTime = averageBoothTime;
		this.avgCheckInTime = checkInTime;
		//r.setSeed(13);    // This will cause the same random numbers
	}
	
	public void event(int tick) {
		if (nextPerson <= tick) {
			nextPerson = tick + numOfTicksNextPerson;
			
			Voter person = new Voter();
			
			int rNumber = (int)(Math.random() * 100);

			person.setBoothTime(averageBoothTime*0.5*r.nextGaussian() + averageBoothTime +0.5);
			person.setTickTime(tick);
			person.setCheckInTime(avgCheckInTime*0.5*r.nextGaussian() + avgCheckInTime + 0.5);
			booth.add(person);
			
			//person.setDestination(//random check in booth);  // You can save off where the voter should go.
		}
	}

}
