/**
 * 
 */
package F16Project3StudentHelp;

/**
 * @author   Roger Ferguson
 */
public class Voter {
	private int tickTime;
	private Booth Destination;
	
	
	// max time person stays in line
	protected double boothTime, checkInTime;
	protected int leaveTime;

	public double getBoothTime() {
		return boothTime;
	}
	
	public Booth getDestination() {
		return Destination;
	}
	
	public void setDestination(Booth destination) {
		Destination = destination;
	}
	
	public int getTickTime() {
		return tickTime;
	}

	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}

	public void setBoothTime(double checkInTime) {
		this.boothTime = checkInTime;
	}

	public double getCheckInTime() {
		return this.checkInTime;
	}
	
	public void setCheckInTime(double checkInTime){
		this.checkInTime = checkInTime;
	}
	public void setLeaveTime(int leaveTime){
		this.leaveTime = leaveTime;
	}
	public void setVotingBoothTime(double votingBoothTime){
		this.boothTime = votingBoothTime;
	}

}
