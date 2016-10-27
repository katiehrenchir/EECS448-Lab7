import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class MultTempConversion 
{
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel;

	private JButton button;
	private JTextField tempVal;

	private JLabel label;
	private JLabel toLabel;
	
	private JComboBox<String> startScaleList;
	private JComboBox<String> endScaleList;
	
	private String startSc = " ";
	private String endSc = " ";

	InputVerifier verifier = new NumInputVerifier();

	public MultTempConversion()
	{
		String[] scaleStrings = {" ", "F", "C", "K"};
		
        startScaleList = new JComboBox<>(scaleStrings);
        startScaleList.setSelectedIndex(0);
        
        endScaleList = new JComboBox<>(scaleStrings);
        endScaleList.setSelectedIndex(0);
	
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		button = new JButton("Convert");
		tempVal = new JTextField(4);//3 cols, not 20 chars


		label = new JLabel("Enter a temperature");

		toLabel = new JLabel(" to ");

		//Load the listener
		button.addActionListener(buttonListener());	
		startScaleList.addActionListener( startListener() );
		endScaleList.addActionListener( endListener() );
		
		//load the panel
		panel2.add(startScaleList);
		panel2.add(toLabel);
		panel2.add(endScaleList);
		
		panel1.add(tempVal);
		panel1.add(button);
		panel1.add(label);
		
		panel = new JPanel();

		panel.add(panel1,0);
		panel.add(panel2, 0);
		
		//verify that the temperature input is present & a number
		tempVal.setInputVerifier(verifier);

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
				String newText = "";
				if(!verifier.verify(tempVal)){
					newText = "Invalid temperature input";
				} else {
					
					if(!scaleCheck().equals("clear")){
						newText = scaleCheck();
					} else {
				
						String tempValue = tempVal.getText();
						double temp = Double.parseDouble(tempValue);//convert String to double
						
						double newTemp = 0.0;
						if(startSc.equals("F")){
							
							newTemp = fConvert(endSc, temp);
							
						} else if( startSc.equals("C")){
							
							newTemp = cConvert(endSc, temp);
							
						} else if( startSc.equals("K")){
							
							newTemp = kConvert(endSc, temp);
							
						}
						
						newText = "Converted temperature: " + String.format("%.2f",newTemp);//convert double to String and display
					}
				}
				
				label.setText(newText);
				System.out.println(newText);
				
			}
		};
		
		return listener;
	}	
	
	private ActionListener startListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{				
		        JComboBox<String> combo = (JComboBox<String>) e.getSource();
		        String begScale = (String) combo.getSelectedItem();
		        startSc = begScale;
				System.out.println(begScale);

			}
		};
		
		return listener;
	}	
	
	private ActionListener endListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{				
		        JComboBox<String> combo = (JComboBox<String>) e.getSource();
		        String endScale = (String) combo.getSelectedItem();
		        endSc = endScale;
				System.out.println(endScale);

			}
		};
		
		return listener;
	}	
	
	private String scaleCheck(){
		String check = "clear";
		if(startSc.equals(" ") || endSc.equals(" ")){
			check = "Please choose a start/end scale.";
		} else if(startSc.equals(endSc)){
			check = "Please choose non-matching starting and ending scales.";
		}
		return check;
	}
	
	private double fConvert(String scale, double temp){
		double ans = 0;
		if(scale.equals("C")){
			ans = (temp-32)*(5.0/9.0); //convert F to C

		} else if (scale.equals("K")){
			ans = (temp-32)*(5.0/9.0) + 273.15 ; //convert F to K

		} 
		return ans;
		
	}
	private double cConvert(String scale, double temp){
		double ans = 0;
		if(scale.equals("F")){
			ans = (temp * 1.8) + 32.0; //convert C to F

		} else if (scale.equals("K")){
			ans = temp + 273.15 ; //convert C to K

		} 
		return ans;
		
	}
	private double kConvert(String scale, double temp){
		double ans = 0;
		if(scale.equals("F")){
			ans = (temp *1.8) -459.67 ; //convert K to F

		} else if (scale.equals("C")){
			ans = temp - 273.15 ; //convert K to C

		} 
		return ans;
		
	}
}