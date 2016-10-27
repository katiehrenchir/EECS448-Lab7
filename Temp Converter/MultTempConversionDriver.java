import javax.swing.JFrame;


public class MultTempConversionDriver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Tri-Scale Temperature Converter");
		MultTempConversion demo = new MultTempConversion();
		
		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setSize(400, 200);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}