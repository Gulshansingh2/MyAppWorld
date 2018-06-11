package mainFrame;

import java.awt.Button;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainApp extends JFrame{

	Container c = null;
	
	public MainApp()
	{
		setLayout(null);
		
		setResizable(false);
		c = getContentPane();
		ImageIcon ikn = new ImageIcon("Jarvis.jpg");
		JLabel lblBG = new JLabel(ikn);
		lblBG.setBounds(0,-40,750,800);
		//lblBG.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lblBG);

		
		String strBtnNames[]={"Snake Game","Brick Breaker","Calculator","ChatBot","Date Validator","Media Player","Source Getter","TicTacToe","About"};
		String strImage[]={"snake1.jpg","BrickBreaker.jpg","calc.jpg","chatbot.jpg","dateValid.jpg","mediaplayer.jpg","code.jpg","TicTacToe.png","about.jpg"};
		JButton btn[] = new JButton[9];
		int i;
		int xpos=70, ypos = 100;
		for(i=0; i<9; i++)
		{	
			if(i == 3 || i== 6)
			{
				xpos = 70;
				ypos += 220;
			}
			
			ImageIcon iknBtnShowDate =new ImageIcon(strImage[i]);
			btn[i] = new JButton(iknBtnShowDate);
			btn[i].setActionCommand(strBtnNames[i]);
			btn[i].setBounds(xpos, ypos, 170, 170);
			lblBG.add(btn[i]);
			xpos += 220;
			btn[i].addActionListener(new ButtonHandle(this));
		}
		
		setTitle("App World");
		setSize(750,750);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
