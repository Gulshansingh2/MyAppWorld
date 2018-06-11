package Calc;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcMainController {
	
	
	private BigDecimal left;
	private String selectedOperator;
	private boolean numberInputting;
	
	@FXML
	private TextField textfield;
	
	public CalcMainController()
	{
		this.left = BigDecimal.ZERO;
		this.selectedOperator = "";
		this.numberInputting = false;
	}
	
	@FXML
	public void operateButton(ActionEvent evt)
	{
		Button btn = (Button)evt.getSource();
		final String btnTxt = btn.getText();
		
		if(btnTxt.equals("C"))
		{
			if(btnTxt.equals("C"))
			{
				left = BigDecimal.ZERO;
			}
			
			selectedOperator="";
			numberInputting = false;
			//numberInputting = true;
			textfield.setText("0");
			return;
		}
		
		if(btnTxt.matches("[0-9\\.]"))
		{
			if(!numberInputting)
			{
				numberInputting = true;
				textfield.clear();
			}
			
			textfield.appendText(btnTxt);
			return;
		}
		
		if(btnTxt.matches("[+*-/]"))
		{
			left = new BigDecimal(textfield.getText());
			selectedOperator = btnTxt; 
			numberInputting  = false;
			return;
		}
		  
		if(btnTxt.equals("="))
		{
			final BigDecimal right = numberInputting ? new BigDecimal(textfield.getText()) : left;
			
			left = calculate(selectedOperator,left,right);
			textfield.setText(left.toString());
			numberInputting = false;
			selectedOperator = "";
			return;
		}
		
	}
	
	public static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right)
	{
		switch(operator)
		{
		case "+":
			return left.add(right);
		case "-":
			return left.subtract(right);
		case "*":
			return left.multiply(right);
		case "/":
			return left.divide(right);
		default:
		}
		
		return right;
	}
	
	

}
