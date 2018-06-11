package Calendar;

import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class dateFrame extends JFrame {
	
	Container c = null;
	JTextField arrTxt[] = new JTextField[6];
	public dateFrame()
	{
		setLayout(null);
		setResizable(false);
		c = getContentPane();
		ImageIcon ikn = new ImageIcon("BG1.jpg");
		JLabel lblBG = new JLabel(ikn);
		lblBG.setBounds(-800,0,1500,500);
		//lblBG.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lblBG);
		
		int i;
	
		// JLabel
		String strLabel[] = {"Enter Date","dd:", "mm:", "yy:", "Add Days:", "Add Months:"};
		JLabel arrLabel[] = new JLabel[6];
		
		arrLabel[0] = new JLabel(strLabel[0]);
		arrLabel[0].setBounds(850, 80, 120, 20);
		Font myFont = new Font("Serif",Font.ITALIC,20);
        arrLabel[0].setFont(myFont);
		lblBG.add(arrLabel[0]);
		
		int yposLbl[]={0,120,160,200,130,190};
		int xposLbl[]={0,865,865,865,1200,1200};
				
		for(i=1; i<6; i++)
		{
			arrLabel[i] = new JLabel(strLabel[i]);
			arrLabel[i].setBounds(xposLbl[i], yposLbl[i], 95, 20);
			myFont = new Font("Serif",Font.ITALIC,17);
            arrLabel[i].setFont(myFont);
			lblBG.add(arrLabel[i]);
		}
		
				
		//JTextFields
		int xpostxt[] = {960,960,960,1320,1320};
		int ypostxt[] = {120,160,200,130,190};
		for(i=0;i<5;i++)
		{
			arrTxt[i] = new JTextField();
			arrTxt[i].setBounds(xpostxt[i],ypostxt[i],120,25);
			myFont = new Font("Aerial",Font.PLAIN,17);
			arrTxt[i].setFont(myFont);
			lblBG.add(arrTxt[i]);
		}
		arrTxt[5] = new JTextField();
		arrTxt[5].setBounds(1170,300,120,25);
		myFont = new Font("Aerial",Font.PLAIN,17);
		arrTxt[5].setFont(myFont);
		lblBG.add(arrTxt[5]);
		
		//JButtons
		ImageIcon iknBtnShowDate =new ImageIcon("button_show-date.png");
		JButton btn[] = new JButton[2];
			btn[0] = new JButton(iknBtnShowDate);
			btn[0].setBounds(1020, 300, 105, 30);
			myFont = new Font("Aerial",Font.PLAIN,15);
			btn[0].setFont(myFont);
			lblBG.add(btn[0]);
			btn[0].addActionListener(new ButtonHandler(this));
			
			ImageIcon iknBtnExit =new ImageIcon("button_exit.png");
			btn[1] = new JButton(iknBtnExit);
			btn[1].setBounds(1090, 360, 99, 39);
			myFont = new Font("Aerial",Font.PLAIN,15);
			btn[1].setFont(myFont);
			lblBG.add(btn[1]);
			btn[1].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					
				}
				
			});
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/*addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});*/
		
		setVisible(true);
		setTitle("Date Calculator");
		//setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setBounds(0,0,700,500);
	}
	
}
