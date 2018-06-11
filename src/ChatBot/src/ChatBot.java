package ChatBot.src;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class ChatBot extends JFrame implements KeyListener{

//	JPanel p = new JPanel();
	JTextArea dialog = new JTextArea();
	JTextArea input = new JTextArea();
	Container c = null;
    
	JScrollPane scroll = new JScrollPane(
			dialog,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
			);
	
	String[][] chatBot = {
			//standard greetings
			{"hi","hello","hola","hey","Hi there!","bonjour"},
			{"Hi","Hello","Hola","Hey","Bonjour","Hi there!"},
			//questions
			{"how are you","how r u", "how r you","how are u"},
			{"I'm fine","good","doing well","Awesome"},
			{"what's your name","what is your name","what's ur name","what is ur name"},
			{"CAM - A ChatBot"},
			{"what are you doing","what's up","whats up","sup"},
			{"nothing much","I'm doing great","I'm bored"},
			{"why","when","where"},	
			{"IDK"},
			// Thanks
			{"thank you","thanks","thanx"},
			{"You are welcome"},
			{"good","very good","gud","very gud","you are smart","u are smart","u r smart"},
			{"thank you","thanks","I know I'm Awesome"},
			//ok
			{"oh","ok","okay"},
			{"hmmm","yup"},
			// finishers
			{"good bye","tata","bye","ok bye"},
			{"good bye","tata","bye","catch you later","ok bye","see you later","adios"},
			{"good night","sweet dreams"},
			{"good night","sweet dreams","sleep is coming"},
			//default
			{"cool","hmmmmm","ssshhhh","noob","I'm bored","talk to you later","Unavailable coz I'm busy ._.","see you later",
			"lets talk about something else",""}
	};
	
	public ChatBot()
	{
		
		setLayout(null);
		c = getContentPane();
		ImageIcon ikn = new ImageIcon("BG.jpg");
		JLabel lblBG = new JLabel(ikn);
		lblBG.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lblBG);
		
		dialog.setEditable(false);
		input.addKeyListener(this);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		scroll.setBounds(50,50,500,450);
		scroll.setBorder(border);
		input.setBounds(50, 520, 500, 40);
		input.setBorder(border);
		Font myFont = new Font("Comic Sans MS",Font.PLAIN,20);
		input.setFont(myFont);
		dialog.setFont(myFont);
		lblBG.add(input);
		lblBG.add(scroll);
		setTitle("Chat Bot");
		setVisible(true);
		setSize(650,650);
		//setResizable(false);
		setDefaultCloseOperation(2);
		
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
		{
			input.setEditable(false);
			// get the messgae
			String quote = input.getText();
			input.setText("");
			quote = quote.trim();
			if(quote.isEmpty())
				quote=" ";
			addText("-->You:\t"+quote);
			// take away punctuations 
			while(quote.charAt(quote.length()-1) == '!' || 
				  quote.charAt(quote.length()-1) == '.'||
				  quote.charAt(quote.length()-1) == '?')
			{
				quote = quote.substring(0,quote.length()-1);
			}
			quote = quote.trim();
			
			byte response = 0; 
			/*
			 * 0: we're searching through chatBot[][] for matches
			 * 1: we didn't find anything in chatBot[][]
			 * 2: we did find something in chatBot[][]
			 */
			// check for matches
			int j = 0; // which group we are checking
			while(response == 0)
			{
				if(inArray(quote.toLowerCase(), chatBot[j*2]))
				{
					response = 2;
					int r = (int)Math.floor(Math.random()*chatBot[(j*2)+1].length); // random no. between 0 and 1
					addText("\n--> Cam: \t"+chatBot[(j*2)+1][r]);
				}
				j++;
				if(j*2 == chatBot.length-1 && response==0)
				{
					response = 1;
				}
			}
			// default
			if(response == 1)
			{
				int r = (int)Math.floor(Math.random()*chatBot[chatBot.length-1].length); // random no. between 0 and 1
				addText("\n--> Cam: \t"+chatBot[chatBot.length-1][r]);
				
			}
			
			addText("\n");
		}
		
	}


	private boolean inArray(String in, String[] str ){
		boolean match = false;
		for(int i =0; i<str.length;i++)
		{
			if(str[i].equals(in))
			{
				match = true;
			}
		}
		return match;
	}

	private void addText(String str) {
		dialog.setText(dialog.getText()+str);
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
		{
			input.setEditable(true);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
