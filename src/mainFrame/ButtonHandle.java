package mainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import BrickBreaker.BrickBreaker;
import Calc.Calc;
import Calendar.DriveCalender;
import ChatBot.src.DriverchatBot;
import MediaPlayer.MainMedia;
import Snake.Snake;
import SourceGetter.src.entryMainSourceGetter;


public class ButtonHandle implements ActionListener {

	MainApp f;
	public ButtonHandle(MainApp frm) {
		f=frm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String strAcmd = arg0.getActionCommand();
		if(strAcmd.equals("Snake Game"))
		{
			Snake.main(new String[]{});
		}
		
		if(strAcmd.equals("Brick Breaker"))
		{
			BrickBreaker.main(new String[]{});
		}
		
		if(strAcmd.equals("Calculator"))
		{
			
			Calc.main(new String[]{});
		}
		
		if(strAcmd.equals("ChatBot"))
		{
			DriverchatBot.main(new String[]{});
		}
		
		if(strAcmd.equals("Date Validator"))
		{
			DriveCalender.main(new String[]{});
		}
		
		if(strAcmd.equals("Media Player"))
		{
			MainMedia.main(new String[]{});
		}
		
		if(strAcmd.equals("Source Getter"))
		{
			entryMainSourceGetter.main(new String[]{});
		}
		
		if(strAcmd.equals("TicTacToe"))
		{
			String url = "F:/Gulshan Singh/Courses/Core Java/mainFrame/tictactoe/tic_tac_toe 1.0.html";
			File htmlFile = new File(url);
			try {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(strAcmd.equals("About"))
		{
			new About();
		}
	

	}

}
