package Objects;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class JStuff {
	

	public static void JFrame(JFrame frame){
		frame.setEnabled(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(900,200);
		frame.setSize(800,500);
		frame.getContentPane().setBackground(Color.darkGray);
		frame.setLayout(null);
	}//JFrame method
	public static void JFrame(JFrame frame, String preset){
		frame.setEnabled(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.darkGray);
		frame.setLayout(null);
		switch (preset){
		case "main":
			
			break;
		case "applet":
			frame.setLocation(1000,300);
			frame.setSize(300,400);
			break;
		}
	}//JFrame method2
	public static void JPanel (JPanel panel){
		panel.setEnabled(true);
		panel.setVisible(true);
		panel.setBackground(Color.lightGray);
		panel.setLayout(null);
		panel.setSize(800,500);
	}//JPanel method
	public static void JPanel (JPanel panel, String preset){
		panel.setEnabled(true);
		panel.setVisible(true);
		panel.setBackground(Color.lightGray);
		panel.setLayout(null);
		switch (preset){
		case "main":
			panel.setSize(800,500);
			break;
		case "applet":
			panel.setSize(300,400);
			break;
		}
	}//JPanel method2
	public static void JButton (JButton button, String preset){
		button.setEnabled(true);
		button.setVisible(true);
		button.setBackground(Color.lightGray.brighter());
		switch (preset){
		case "calcButt":
			button.setSize(50,30);
			break;
		case "":

		break;
		}
		
	}
	
}//JStuff class
