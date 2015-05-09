import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class TI82 {
	
	
	public static JFrame frame = new JFrame ();
	public static JPanel bg = new JPanel ();
	public static JButton butt1, butt2, butt3, butt4, butt5;
	public static JButton butt6, butt7, butt8, butt9, butt0;
	public static JButton plus, minus, eql;
	public static JButton clear; 
	public static JTextArea screen;
	
	public static double oldNum = 0;
	public static double newNum = 0;
	public static double ans;
	
	public static boolean add = false;
	public static boolean sub = false;
	public static boolean mul = false;
	public static boolean div = false;
	
	
	public static void main (String Args[]){
		frame = new JFrame ();
		frame.setTitle("TI-82");
		frame.setSize(300,400);
		frame.setLocation(1000,300);
		frame.setLayout(null);
		frame.setEnabled(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.black);
		
		bg = new JPanel();
		bg.setSize(280,355);
		bg.setVisible(true);
		bg.setEnabled(true);
		bg.setLocation(10,10);
		bg.setLayout(null);
		bg.setBackground(Color.lightGray);
		frame.add(bg);
		
		screen = new JTextArea ();
		screen.setSize(230,50);
		screen.setLocation(10,10);
		Font font = new Font("Verdana", Font.PLAIN, 40);
		screen.setFont(font);
		screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		screen.setBackground(Color.green.brighter());
		screen.setText("0");
		bg.add(screen);
		
		loadCalc();
		clear();
		
		frame.pack();
		frame.setSize(300,400);
	}//main method
	public static void loadCalc(){
		int width = 50;
		int height = 30;
		int x[] = new int[4];
		int y[] = new int[4];
		
		x[0]=10;
		x[1]=x[0]+width+10;
		x[2]=x[1]+width+10;
		x[3]=x[2]+width+10;
		
		y[0]=70+10;
		y[1]=y[0]+height+10;
		y[2]=y[1]+height+10;
		y[3]=y[2]+height+10;
		
		plus = new JButton ();
		plus.setEnabled(true);
		plus.setVisible(true);
		plus.setSize(width,height);
		plus.setLocation(x[0],y[3]);
		plus.setText("+");
		plus.setBackground(Color.red.brighter());
		plus.addActionListener(new plus());
		bg.add(plus);
		
		minus = new JButton ();
		minus.setEnabled(true);
		minus.setVisible(true);
		minus.setSize(width,height);
		minus.setLocation(x[1],y[3]);
		minus.setText("-");
		minus.setBackground(Color.red.brighter());
		minus.addActionListener(new minus());
		bg.add(minus);
		
		eql = new JButton ();
		eql.setEnabled(true);
		eql.setVisible(true);
		eql.setSize(width+10,height);
		eql.setLocation(x[3],y[1]);
		eql.setText("=");
		eql.setBackground(Color.blue.brighter());
		eql.addActionListener(new eql());
		bg.add(eql);
		
		clear = new JButton ();
		clear.setEnabled(true);
		clear.setVisible(true);
		clear.setSize(width+10,height);
		clear.setLocation(x[3],y[0]);
		clear.setText("AC");
		clear.setBackground(Color.red.brighter());
		clear.addActionListener(new clear());
		bg.add(clear);
		
		butt1 = new JButton ();
		butt1.setVisible(true);
		butt1.setEnabled(true);
		butt1.setSize(width,height);
		butt1.setBackground(Color.cyan);
		butt1.setLocation(x[0],y[0]);
		butt1.setText("1");
		butt1.addActionListener(new act1());
		bg.add(butt1);
		
		butt2 = new JButton ();
		butt2.setVisible(true);
		butt2.setEnabled(true);
		butt2.setSize(width,height);
		butt2.setBackground(Color.cyan);
		butt2.setLocation(x[1],y[0]);
		butt2.setText("2");
		butt2.addActionListener(new act2());
		bg.add(butt2);
		
		butt3 = new JButton ();
		butt3.setVisible(true);
		butt3.setEnabled(true);
		butt3.setSize(width,height);
		butt3.setBackground(Color.cyan);
		butt3.setLocation(x[2],y[0]);
		butt3.setText("3");
		butt3.addActionListener(new act3());
		bg.add(butt3);
		
		butt4 = new JButton ();
		butt4.setVisible(true);
		butt4.setEnabled(true);
		butt4.setSize(width,height);
		butt4.setBackground(Color.cyan);
		butt4.setLocation(x[0],y[1]);
		butt4.setText("4");
		butt4.addActionListener(new act4());
		bg.add(butt4);
		
		butt5 = new JButton ();
		butt5.setVisible(true);
		butt5.setEnabled(true);
		butt5.setSize(width,height);
		butt5.setBackground(Color.cyan);
		butt5.setLocation(x[1],y[1]);
		butt5.setText("5");
		butt5.addActionListener(new act5());
		bg.add(butt5);
		
		butt6 = new JButton ();
		butt6.setVisible(true);
		butt6.setEnabled(true);
		butt6.setSize(width,height);
		butt6.setBackground(Color.cyan);
		butt6.setLocation(x[2],y[1]);
		butt6.setText("6");
		butt6.addActionListener(new act6());
		bg.add(butt6);
		
		butt7 = new JButton ();
		butt7.setVisible(true);
		butt7.setEnabled(true);
		butt7.setSize(width,height);
		butt7.setBackground(Color.cyan);
		butt7.setLocation(x[0],y[2]);
		butt7.setText("7");
		butt7.addActionListener(new act7());
		bg.add(butt7);
		
		butt8 = new JButton ();
		butt8.setVisible(true);
		butt8.setEnabled(true);
		butt8.setSize(width,height);
		butt8.setBackground(Color.cyan);
		butt8.setLocation(x[1],y[2]);
		butt8.setText("8");
		butt8.addActionListener(new act8());
		bg.add(butt8);
	
		butt9 = new JButton ();
		butt9.setVisible(true);
		butt9.setEnabled(true);
		butt9.setSize(width,height);
		butt9.setBackground(Color.cyan);
		butt9.setLocation(x[2],y[2]);
		butt9.setText("9");
		butt9.addActionListener(new act9());
		bg.add(butt9);
	}
	
	public static void clear(){
		oldNum = 0;
		newNum = 0;
		ans = 0;
		add = false;
		sub = false;
		mul = false;
		div = false;
		screen.setText("0");
		
	}//clear method
		
}//TI82 class

class clear implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		TI82.clear();
	}
}//clear method
class eql implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
//		System.out.println("Nums: " + TI82.oldNum + " " + TI82.newNum);
		if (TI82.sub){
			TI82.oldNum -= TI82.newNum;
		} else if (TI82.add){
			TI82.oldNum += TI82.newNum;
		} else if (TI82.mul){
			TI82.oldNum *= TI82.newNum;
		}
		TI82.newNum=0;
//		TI82.oldNum = TI82.oldNum + TI82.newNum;
		TI82.screen.setText(""+TI82.oldNum);
//		System.out.println("Nums: " + TI82.oldNum + " " + TI82.newNum);
	}
}//eql method

/////////////////////////////////////////////////////
///////////////GENERAL OPERATIONS////////////////////

class minus implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){

		TI82.eql.doClick();
		TI82.sub = true;
		TI82.add = false;
		TI82.mul = false;

		//		double ans = TI82.oldNum - TI82.newNum;
//		TI82.oldNum = TI82.oldNum - TI82.newNum;
//		TI82.screen.setText(""+ans);
	}
}//minus method
class plus implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		TI82.eql.doClick();
		TI82.add = false;
		TI82.sub = false;
		TI82.mul = true;
		//		double ans;
//		ans = TI82.oldNum + TI82.newNum;
//		TI82.oldNum = TI82.oldNum + TI82.newNum;
//		TI82.screen.setText(""+ans);
	}
}//plus method
class mult implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		TI82.eql.doClick();
		TI82.add = false;
		TI82.sub = false;
		TI82.mul = true;
		//		double ans;
//		ans = TI82.oldNum + TI82.newNum;
//		TI82.oldNum = TI82.oldNum + TI82.newNum;
//		TI82.screen.setText(""+ans);
	}
}//mult method

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//


////////////////////////////BUTTONS ACTIONS BELOW////////////////////////////////////////
class act1 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if (TI82.add||TI82.sub||TI82.mul||TI82.div){
			TI82.newNum = (TI82.newNum * 10) + 1;
			TI82.screen.setText(""+TI82.newNum);
		} else {
			TI82.oldNum = (TI82.oldNum * 10) + 1;
			TI82.screen.setText(""+TI82.oldNum);
		}
	}//actionPerformed method
}//act1 class
class act2 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if (TI82.add||TI82.sub||TI82.mul||TI82.div){
			TI82.newNum = (TI82.newNum * 10) + 2;
			TI82.screen.setText(""+TI82.newNum);
		} else {
			TI82.oldNum = (TI82.oldNum * 10) + 2;
			TI82.screen.setText(""+TI82.oldNum);
		}
	}//actionPerformed method
}//act2 class
class act3 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if (TI82.add||TI82.sub||TI82.mul||TI82.div){
			TI82.newNum = (TI82.newNum * 10) + 3;
			TI82.screen.setText(""+TI82.newNum);
		} else {
			TI82.oldNum = (TI82.oldNum * 10) + 3;
			TI82.screen.setText(""+TI82.oldNum);
		}
	}//actionPerformed method
}//act3 class
class act4 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if (TI82.add||TI82.sub||TI82.mul||TI82.div){
			TI82.newNum = (TI82.newNum * 10) + 4;
			TI82.screen.setText(""+TI82.newNum);
		} else {
			TI82.oldNum = (TI82.oldNum * 10) + 4;
			TI82.screen.setText(""+TI82.oldNum);
		}
	}//actionPerformed method
}//act4 class
class act5 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if (TI82.add||TI82.sub||TI82.mul||TI82.div){
			TI82.newNum = (TI82.newNum * 10) + 5;
			TI82.screen.setText(""+TI82.newNum);
		} else {
			TI82.oldNum = (TI82.oldNum * 10) + 5;
			TI82.screen.setText(""+TI82.oldNum);
		}
	}//actionPerformed method
}//act5 class
class act6 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if (TI82.add||TI82.sub||TI82.mul||TI82.div){
			TI82.newNum = (TI82.newNum * 10) + 6;
			TI82.screen.setText(""+TI82.newNum);
		} else {
			TI82.oldNum = (TI82.oldNum * 10) + 6;
			TI82.screen.setText(""+TI82.oldNum);
		}
	}//actionPerformed method
}//act6 class
class act7 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if (TI82.add||TI82.sub||TI82.mul||TI82.div){
			TI82.newNum = (TI82.newNum * 10) + 7;
			TI82.screen.setText(""+TI82.newNum);
		} else {
			TI82.oldNum = (TI82.oldNum * 10) + 7;
			TI82.screen.setText(""+TI82.oldNum);
		}
	}//actionPerformed method
}//act7 class
class act8 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if (TI82.add||TI82.sub||TI82.mul||TI82.div){
			TI82.newNum = (TI82.newNum * 10) + 8;
			TI82.screen.setText(""+TI82.newNum);
		} else {
			TI82.oldNum = (TI82.oldNum * 10) + 8;
			TI82.screen.setText(""+TI82.oldNum);
		}
	}//actionPerformed method
}//act8 class
class act9 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		if (TI82.add||TI82.sub||TI82.mul||TI82.div){
			TI82.newNum = (TI82.newNum * 10) + 9;
			TI82.screen.setText(""+TI82.newNum);
		} else {
			TI82.oldNum = (TI82.oldNum * 10) + 9;
			TI82.screen.setText(""+TI82.oldNum);
		}
	}//actionPerformed method
}//act9 class
