import javax.swing.JFrame;


public class DiceRollDriver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Dice Roller");
		DiceRoll demo = new DiceRoll();
		
		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}