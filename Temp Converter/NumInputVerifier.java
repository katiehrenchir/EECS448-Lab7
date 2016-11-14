import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;


public class NumInputVerifier extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
       String text = ((JTextField) input).getText();
       try {
          Double.parseDouble(text);
       } catch (NumberFormatException e) {
    	   System.out.println("NOT A NUMBER");
          return false;
       }

       return true;
    }
}
