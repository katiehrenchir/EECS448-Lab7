import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Random;

public class DiceRoll 
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	
	public DiceRoll()
	{
		panel = new JPanel();
		button = new JButton("Dice Roll");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a number of sides");
		
		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(text);
		panel.add(button);
		panel.add(label);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				
				String input = text.getText();
				int sides = Integer.parseInt(input);//convert String to int
				
				Random rand = new Random();
				int rollValue = rand.nextInt(sides) +1 ;
				String newText = "Roll: " + rollValue;
				label.setText(newText);
				System.out.println(newText);
			}
		};
		
		return listener;
	}	
}