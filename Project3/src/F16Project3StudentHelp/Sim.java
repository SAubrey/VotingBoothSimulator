/**
 * 
 */
package F16Project3StudentHelp;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Roger Ferguson
 *
 */
public class Sim {
	ArrayList<Booth> booths;
	VoterProducer produce;
	Clock clk;
	ArrayList<CheckIn> tables;
	VoteBoothLine voteLine;
	
	public Sim(){
		booths = new ArrayList<Booth>();
		tables = new ArrayList<CheckIn>();
		voteLine = new VoteBoothLine();
		clk = new Clock();
	}
	
	public Sim(int numBooths){
		booths = new ArrayList<Booth>();
		createBooth();
		createBooth();
		tables = new ArrayList<CheckIn>();
		voteLine = new VoteBoothLine();
		clk = new Clock();
	}
	public static void main (String[] args) {
			
			Sim s = new Sim();
			s.createBooth();
			s.createCheckIn();
			
			int numOfTicksNextPerson = 20; 
		      int averageBoothTime = 20;
		      int avgCheckTime = 15;
			s.produceBooth(s.getRandTable(), numOfTicksNextPerson, averageBoothTime, avgCheckTime);
			
			s.run(10000);
			
			
		//	System.out.println("Through put is: " +s.getThroughPut() + " people.");
		//	System.out.println("People that are still in the Q: " + s.getLeft() + " people.");
		//	System.out.println ("Max Q length: " + s.getMaxQlength() + " people.");
		}
	

	public CheckIn getRandTable() {
		//will return random check in table
		//TODO change to random table 
		Random rand = new Random();
		int tableNum = rand.nextInt(tables.size());
		return tables.get(tableNum);
	}
	public void createCheckIn() {
		CheckIn chkIn = new CheckIn();
		tables.add(chkIn);
	}
	
	public void createBooth(){
		Booth booth = new Booth();
		booths.add(booth);
	}

	public Booth getBooth(int index){
		Booth b = new Booth();
		b = booths.get(index);
		return b;
	}
	
	public void produceBooth(Booth b, int ticksTillNext, int avgBoothTime,
			int avgCheckIn){
		produce = new VoterProducer(b, ticksTillNext, avgBoothTime, avgCheckIn);
		clk.add(produce);
	}
	
	public void run(int time){
		for(int i = 0; i < booths.size(); i++){
			clk.add(booths.get(i));
		}
		clk.add(tables.get(0));
		clk.add(tables.get(1));
		clk.add(voteLine);
		clk.run(time);
	}
}