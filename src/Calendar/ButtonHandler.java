package Calendar;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ButtonHandler implements ActionListener {

	dateFrame f;
	int dd=0, mm=0, yy=0;
	public ButtonHandler(dateFrame frm) {
		f=frm;
		/*f.arrTxt[4].setText("0");
		f.arrTxt[3].setText("0");
		f.arrTxt[2].setText("0");
		f.arrTxt[1].setText("0");
		f.arrTxt[0].setText("0");
*/	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
			dd = Integer.parseInt(f.arrTxt[0].getText());
			mm = Integer.parseInt(f.arrTxt[1].getText());
			yy = Integer.parseInt(f.arrTxt[2].getText());

			int x = dateCheck(dd,mm,yy);
			if(x == 0)
			{
				JOptionPane.showMessageDialog(null, "Plz Enter a valid date!", "Oops", JOptionPane.WARNING_MESSAGE);
				
				dd = 0; mm = 0 ; yy = 0;
				f.arrTxt[4].setText("0");
				f.arrTxt[3].setText("0");
				f.arrTxt[2].setText("0");
				f.arrTxt[1].setText("0");
				f.arrTxt[0].setText("0");
	
			}
			
			int d = Integer.parseInt(f.arrTxt[3].getText());
			d+=dd;
			dateValidate(d);
		
			int m = Integer.parseInt(f.arrTxt[4].getText());
			m+=mm;
			monthValidate(m);
			
			String date = dd + "-"+mm+"-"+yy;
			f.arrTxt[5].setText(date);
			
		}

	private void monthValidate(int m) {
		if(m>12)
		{
			mm = m -12;
			yy++;
			monthValidate(mm);
		}
		else
		mm=m;
	}
	

	private void dateValidate(int d) {
		if(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)
		{
			if(d>31)
			{
				dd = d-31;
				mm++;
				monthValidate(mm);
				dateValidate(dd);
			}
			else dd=d;
		}
		
		else if(mm==2||mm==4||mm==6||mm==9||mm==11)
		{
			if(mm==2)
			{
				if(((yy%4==0) && (yy%100!=0)) ||(yy%400==0))
				{	
					if(d>29)
					{	
						dd = d-29;
						mm++;
						monthValidate(mm);
						dateValidate(dd);
					}
					else dd=d;
				}
				else
				{
					if(d>28)
					{
						dd = d-28;
						mm++;
						monthValidate(mm);
						dateValidate(dd);
					}
					else dd=d;
				}
			}
			else 
			{
				if(d>30)
				{
					dd = d-30;
					mm++;
					monthValidate(mm);
					dateValidate(dd);
				}
				else dd=d;
			}
			
		}
		
	}

	private int dateCheck(int dd2, int mm2, int yy2) {
		if(dd<1 || mm<1 || mm>12)
			return 0;
		
		if(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)
			if(dd>31)
				return 0;
		
		if(mm==4||mm==6||mm==9||mm==11) 
				if(dd>30)
					return 0;
		if(mm==2)
		{
			if((yy % 400 == 0) || ((yy % 4 == 0) && (yy % 100 != 0)))
			{
				if(dd>29)
					return 0;
			}		
			else 
			{
				if(dd>28)
				return 0;
			}
		}
		return 1;
	}

}
