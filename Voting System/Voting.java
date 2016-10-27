import javax.swing.*;

import java.awt.Component;
import java.awt.event.*;
import java.io.IOException;

public class Voting
{
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel mainPanel;
	
	
	private JTextField firstN;
	private JTextField lastN;
	private JLabel fNameInstructions;
	private JLabel lNameInstructions;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JLabel voteInstructions;
	
	private JButton buttonS;
	
	private String choice = "";
	private String first = "";
	private String last = "";
	
	public Voting()
	{
		
		firstN = new JTextField(20);
		lastN = new JTextField(20);
		fNameInstructions = new JLabel("First: ");
		lNameInstructions = new JLabel("Last: ");

		
		button1 = new JButton("Candidate 1");
		button2 = new JButton("Candidate 2");
		button3 = new JButton("Candidate 3");
		button4 = new JButton("Candidate 4");
		voteInstructions = new JLabel("No candidate selected yet");
		
		//Add the listeners to their respective buttons
		button1.addActionListener( button1Action() );
		button2.addActionListener( button2Action() );
		button3.addActionListener( button3Action() );
		button4.addActionListener( button4Action() );
		
		buttonS = new JButton("Submit Vote");
		buttonS.addActionListener( buttonSAction() );

		
		
		panel1 = new JPanel();
		panel1.add(fNameInstructions);
		panel1.add(firstN);
		panel1.add(lNameInstructions);
		panel1.add(lastN);
						
		panel2 = new JPanel();
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		
		panel3 = new JPanel();
		panel3.add(voteInstructions);	
		
		panel4 = new JPanel();
		panel4.add(buttonS);
		
		mainPanel = new JPanel();
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
	}
	
	public Component getContent()
	{
		return(mainPanel);
	}
	
	private ActionListener buttonSAction() 
	{
		//Create and define an action listener for button1
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	if(nameCheck()){
            		
            		if(!choice.equals("")){
            			
            			VotingFileIO ballotCreate = new VotingFileIO(first, last, choice);
            			String success = "";
						try {
							success = ballotCreate.logBallot();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
            			
                    	voteInstructions.setText(success);

            		} else {
            			
                    	voteInstructions.setText("Please choose a candidate");

            		}
            		

            	} else {
                	voteInstructions.setText("Improper name input");

            	}
            }
        };
        return action;
    }
	
	private boolean nameCheck(){
		
		first = firstN.getText();
		last = lastN.getText();
		
		if(first.equals("") || last.equals("") ){
			return false;
		}

		return true;
	}
	
	private ActionListener button1Action() 
	{
		//Create and define an action listener for button1
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	voteInstructions.setText("Candidate 1 selected");
            	choice = "1";
            }
        };
        return action;
    }
	
	private ActionListener button2Action() 
	{
		//Create and define an action listener for button2
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	voteInstructions.setText("Candidate 2 selected");
            	choice = "2";

            }
        };
        return action;
    }
	
	private ActionListener button3Action() 
	{
		//Create and define an action listener for button1
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	voteInstructions.setText("Candidate 3 selected");
            	choice = "3";

            }
        };
        return action;
    }
	
	private ActionListener button4Action() 
	{
		//Create and define an action listener for button2
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	voteInstructions.setText("Candidate 4 selected");
            	choice = "4";

            }
        };
        return action;
    }
}

