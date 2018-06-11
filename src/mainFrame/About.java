package mainFrame;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class About extends Canvas{

	public About()
	{
		JFrame f=new JFrame();  
        f.add(this);  
        f.setSize(1055,450);  
        f.setVisible(true);  
	}
	
	public void paint(Graphics g) {  
		  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("info.png");  
        g.drawImage(i,0,0,this);  
	}
}

