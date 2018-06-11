package BrickBreaker;

import javax.swing.JFrame;

public class BrickBreaker {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		GameplayBB gameplay = new GameplayBB();
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Breakout Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		obj.add(gameplay);

	}

}
