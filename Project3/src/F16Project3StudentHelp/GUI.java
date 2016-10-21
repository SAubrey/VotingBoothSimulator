package F16Project3StudentHelp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
	
	private Timer javaTimer;
    private TimerListener timer;
	private ButtonListener ml;
    private Sim s;
    private JFrame GUI;
    private JTextField timeNext, avgCheckIn, timeTotal,
    voteTimeAvg, timeLeave, booths;
    
    private JLabel throughput, avgTimeSF, inLine, 
    	maxQAL, maxQMZ, maxQVoteBoothLine;
    private JLabel through, avgTime, numInLine,
    	maxInAL, maxInMZ, maxQBooth;
    private JMenuBar menus;
    private JMenu fileMenu;
    private JMenuItem quitItem, reset;
    private JButton start, quit;
    private final int SIZE = 20;
    public static void main(String[] arg){
    	new GUI();
    }
    
    public GUI(){
    	timer = new TimerListener();
    	s = new Sim();
	    GUI = new JFrame("Voting Simulation"); //creates JFrame
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setLayout(new GridBagLayout());
	    setupMenusOne();
	    GUI.pack();
    }
    
    /* Function used to set up GUI grid system
     * 
     */
    private GridBagConstraints constraints(int x, int y, int h, int w){
        GridBagConstraints rtn=new GridBagConstraints();
        rtn.gridx=x;
        rtn.gridy=y;
        rtn.gridheight=h;
        rtn.gridwidth=w;
        rtn.insets=new Insets(10,10,10,10);
        rtn.anchor=GridBagConstraints.LINE_START;
        return rtn;
    }
    
    private void setupMenusOne(){

        // create menu components
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        reset = new JMenuItem("Reset");
        start = new JButton("Start Simulation");
        quit = new JButton("Quit Simulation");
        timeNext = new JTextField(SIZE);
        avgCheckIn = new JTextField(SIZE);
        timeTotal = new JTextField(SIZE);
        voteTimeAvg = new JTextField(SIZE);
        timeLeave = new JTextField(SIZE);
        booths = new JTextField(SIZE);
        
        //adds GUI objects to GUI with location
        GUI.add(start, constraints(0,7,1,1));
        GUI.add(quit, constraints(1,7,1,1));
        GUI.add(new JLabel("Seconds to Next Person"),
        		constraints(0,1,1,1));
        GUI.add(timeNext, constraints(1,1,1,1));
        GUI.add(new JLabel("Average Seconds to CheckIn"),
        		constraints(0,2,1,1));
        GUI.add(avgCheckIn, constraints(1,2,1,1));
        GUI.add(new JLabel("Total Time in Seconds"),
        		constraints(0,3,1,1));
        GUI.add(timeTotal, constraints(1,3,1,1));
        GUI.add(new JLabel("Average Seconds for Voting"),
        		constraints(0,4,1,1));
        GUI.add(voteTimeAvg, constraints(1,4,1,1));
        GUI.add(new JLabel("Seconds Before Person Leaves"),
        		constraints(0,5,1,1));
        GUI.add(timeLeave, constraints(1,5,1,1));
        GUI.add(new JLabel("Number of Booths"),
        		constraints(0,6,1,1));
        GUI.add(booths, constraints(1,6,1,1));
        GUI.add(new JLabel("Output Information"), constraints(0,8,1,1));
        GUI.add(new JLabel("------------------"), constraints(1,8,1,1));
       
        throughput = new JLabel("Throughput");
        avgTimeSF = new JLabel("Average time Voter, Start -> Finish");
        inLine = new JLabel("Number of Voters Left in Line");
        maxQAL = new JLabel("Max Q length Check in A-L");
        maxQMZ = new JLabel("Max Q length Check in M-Z");
        maxQVoteBoothLine = new JLabel("Max Q length Voting Booth Line");
        
        through = new JLabel("0 people with Max = 500"); 
        		//+Integer.toString(s.getMaxQlength()));
        avgTime = new JLabel("0 seconds");
        numInLine = new JLabel("0 people");
        maxInAL = new JLabel("0");
        maxInMZ = new JLabel("0");
        maxQBooth = new JLabel("0");
        
        GUI.add(throughput, constraints(0,9,1,1));
        GUI.add(avgTimeSF, constraints(0,10,1,1));
        GUI.add(inLine, constraints(0,11,1,1));
        GUI.add(maxQAL, constraints(0,12,1,1));
        GUI.add(maxQMZ, constraints(0,13,1,1));
        GUI.add(maxQVoteBoothLine, constraints(0,14,1,1));
        
        GUI.add(through, constraints(1,9,1,1));
        GUI.add(avgTime, constraints(1,10,1,1));
        GUI.add(numInLine, constraints(1,11,1,1));
        GUI.add(maxInAL, constraints(1,12,1,1));
        GUI.add(maxInMZ, constraints(1,13,1,1));
        GUI.add(maxQBooth, constraints(1,14,1,1));
        
        // assign action listener
        timer = new TimerListener();
        ml = new ButtonListener();
        quitItem.addActionListener(ml);
        quit.addActionListener(ml);
        start.addActionListener(ml);
        reset.addActionListener(ml);
        
        timeNext.setText("20"); 
        avgCheckIn.setText("15"); 
        timeTotal.setText("1000");
        voteTimeAvg.setText("60");
        timeLeave.setText("900");
        booths.setText("3");
        
        // display menu components
        fileMenu.add(quitItem);
        fileMenu.add(reset);
        menus = new JMenuBar();

        menus.add(fileMenu);
        GUI.setJMenuBar(menus);
    }   
    
    
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	
        	through.setText(Integer.toString(s.getThroughPut())+ " people"
     			+ " with Max = "+Integer.toString(s.getMaxQlength()));
     		numInLine.setText(Integer.toString(s.getLeft())+ " people");
     	//	avgTime.setText(Integer.toString(getAvgTime)+ " seconds");
     	//	maxInAL.setText(Integer.toString(getMaxAL));
     	//	maxInMZ.setText(Integer.toString(getMaxMZ));
     	//	maxQBooth.setText(Integer.toString(getMaxQBooth));
        	
        }
    }
    
    private class ButtonListener implements ActionListener {

    	public void actionPerformed(ActionEvent e) {
    
	    	// menu item - quit
	        if (e.getSource() == quitItem){
	            System.exit(1);   
	        }
	        
	        if(e.getSource() == reset){
	        	 timeNext.setText("20"); 
	             avgCheckIn.setText("15"); 
	             timeTotal.setText("1000");
	             voteTimeAvg.setText("60");
	             timeLeave.setText("900");
	             booths.setText("3"); 
	            through.setText("0 people with Max = 500");
	        	avgTime.setText("0 seconds");
	        	numInLine.setText("0");
	        	maxInAL.setText("0");
	        	maxInMZ.setText("0");
	        	maxQBooth.setText("0");
	        }
	        if(e.getSource() == start){
	        	// This calls timer object once per second 
	        	javaTimer = new Timer(1000, timer);
	    	    javaTimer.start();
	    	    s.createBooth();
	    	    s.createCheckIn();
	    	    for(int i = 0; i < s.booths.size(); i++){
	    	    s.produceBooth(s.getRandTable(),
	    	    		Integer.valueOf(timeNext.getText()),
	    	    		Integer.valueOf(voteTimeAvg.getText()),
	    	    		Integer.valueOf(avgCheckIn.getText()));
	    	    }
	    	    s.run(Integer.valueOf(timeTotal.getText()));
	        }
	        
	        if(e.getSource() == quit){
	        	javaTimer.stop();
	        }
    	}
    }
}
