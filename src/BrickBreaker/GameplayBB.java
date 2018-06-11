package BrickBreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameplayBB extends JPanel implements KeyListener, ActionListener{

	private boolean play = false;
	private int score = 0;
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 5;
	
	private int playerX = 310;
	
	private int ballposX = 250;
	private int ballposY = 350;
	private int ballXdir = 1;
	private int ballYdir = 2;
	
	private MapGenerator map;
	
	public GameplayBB()
	{
		map = new MapGenerator(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		// Background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		// drawing map
		map.draw((Graphics2D)g);
		
		//borders
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//score
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString(""+score, 590, 30);
		
		//the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 120, 10);
		
		//the ball
		g.setColor(Color.RED);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		if(score == 105){
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			
			g.setColor(Color.red);
			g.setFont(new Font("aerial", Font.BOLD, 30));
			g.drawString("You Won", 260, 300);
			
			g.setColor(Color.green);
			g.setFont(new Font("aerial", Font.ITALIC, 20));
			g.drawString("Press Enter to restart", 230, 350);
		}
		
		if(ballposY > 570)
		{
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			
			g.setColor(Color.red);
			g.setFont(new Font("aerial", Font.BOLD, 30));
			g.drawString("Game Over! Scores: "+score, 190, 300);
			
			g.setColor(Color.green);
			g.setFont(new Font("aerial", Font.ITALIC, 20));
			g.drawString("Press Enter to restart", 230, 350);
		}
		
		g.dispose();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		
		if(play)
		{
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8)))
			{
				ballYdir = -ballYdir;
			}
			A: for(int i=0; i<map.map.length;i++)
			{
				for(int j=0; j<map.map[0].length;j++)
				{
					if(map.map[i][j]>0)
					{
						int brickX = j*map.brickWidth + 80;
						int brickY = i*map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballrect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						if(ballrect.intersects(brickRect))
						{
							map.setBrickValue(0, i, j);
							totalBricks++;
							score += 5;
							
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width)
							{
								ballXdir = -ballXdir;
							}
							else
							{
								ballYdir = -ballYdir;
							}
							
							break A;
						} 	
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			if(ballposX<0)
			{
				ballXdir = -ballXdir;
			}
			if(ballposY<0)
			{
				ballYdir = -ballYdir;
			}
			if(ballposX>670)
			{
				ballXdir = -ballXdir;
			}
		}
		repaint();
	//	System.out.println("Action Listener Fired");
	} 

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(playerX >= 580)
				playerX = 580;
			else
				moveRight();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(playerX < 10)
				playerX = 2;
			else
				moveLeft();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if(!play)
			{
				play = true;
				score = 0;
				totalBricks = 21;
				playerX = 310;
				
				ballposX = 250;
				ballposY = 350;
				ballXdir = 1;
				ballYdir = 2;
				
				map = new MapGenerator(3,7);
				
				repaint();
			}
			
		}
	//	System.out.println("Key Listener Fired");
	}

	private void moveLeft() {
		play = true;
		playerX-=25;
		
	}

	private void moveRight() {
		play = true;
		playerX+=25;
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
}
