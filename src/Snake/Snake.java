package Snake;

import java.awt.Color;

import javax.swing.JFrame;

public class Snake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame obj = new JFrame();
		SnakeGameplay gameplay = new SnakeGameplay();
		obj.setBounds(10,10,905,700);
		obj.setBackground(Color.darkGray);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		obj.add(gameplay);
		
	}

}
