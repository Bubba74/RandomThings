package Objects;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Calc {
	
	
	public static JFrame frame = new JFrame ();
	public static JPanel bg = new JPanel ();
	public static JButton numButts[] = new JButton[10];
	public static JButton operButts[] = new JButton[4];
	public static JButton plus, minus;
	public static JButton clear, eql; 
	public static JTextArea screen;
	
	public static double oldNum = 0;
	public static double newNum = 0;
	public static double ans;
	
	public static boolean add = false;
	public static boolean sub = false;
	public static boolean mul = false;
	public static boolean div = false;
	public static boolean firstTime = true;
	
	
	public static void main (String Args[]){
		frame = new JFrame ();
		frame.setTitle("TI-82");
		JStuff.JFrame(frame,"applet");
		
		bg = new JPanel();
		JStuff.JPanel(bg, "applet");
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
		
		/*
		plus = new JButton ();
		JStuff.JButton(plus, "calcButt");
		plus.setLocation(x[3],y[0]);
		plus.setText("+");
		plus.addActionListener(new operAction());
		bg.add(plus);
		
		minus = new JButton ();
		JStuff.JButton(minus, "calcButt");
		minus.setLocation(x[3],y[1]);
		minus.setText("-");
		minus.addActionListener(new operAction());
		bg.add(minus);
		*/
		
		for (int i=0;i<operButts.length;i++){
			operButts[i] = new JButton ();
			JStuff.JButton(operButts[i], "calcButt");
			operButts[i].setLocation(x[3],y[i]);
			operButts[i].addActionListener(new operAction());
			bg.add(operButts[i]);
		}
		operButts[0].setText("+");
		operButts[1].setText("-");
		operButts[2].setText("*");
		operButts[3].setText("/");
		
		
		
		eql = new JButton ();
		JStuff.JButton(eql, "calcButt");
		eql.setLocation(x[2],y[3]);
		eql.setText("=");
		eql.addActionListener(new eql());
		bg.add(eql);
		
		clear = new JButton ();
		JStuff.JButton(clear,"calcButt");
		clear.setLocation(x[0],y[3]);
		clear.setText("C");
		clear.addActionListener(new clear());
		bg.add(clear);
		
		for (int i=0;i<numButts.length;i++){
			numButts[i] = new JButton ();
			JStuff.JButton(numButts[i], "calcButt");
			numButts[i].setText(""+i);
			numButts[i].addActionListener(new numAction());
			bg.add(numButts[i]);
		}

		numButts[0].setLocation(x[1],y[3]);
		numButts[1].setLocation(x[0],y[0]);
		numButts[2].setLocation(x[1],y[0]);
		numButts[3].setLocation(x[2],y[0]);
		numButts[4].setLocation(x[0],y[1]);
		numButts[5].setLocation(x[1],y[1]);
		numButts[6].setLocation(x[2],y[1]);
		numButts[7].setLocation(x[0],y[2]);
		numButts[8].setLocation(x[1],y[2]);
		numButts[9].setLocation(x[2],y[2]);
		
	}
	
	public static void clear(){
		oldNum = 0;
		newNum = 0;
		ans = 0;
		add = false;
		sub = false;
		mul = false;
		div = false;
		firstTime = false;
		screen.setText("0");
		
	}//clear method
	public static void eql(){
		System.out.println("Nums: " + oldNum + " " + newNum);
		
		System.out.printf("Eql: Sub is %s, add is %s, mul is %s, div is %s\n",sub,add,mul,div);
		
		if (sub){
			oldNum -= newNum;
		} else if (add){
			oldNum += newNum;
		} else if (mul){
			oldNum *= newNum;
		} else if (div){
			oldNum /= newNum;
		} else {
			System.out.println("no oper match");
		}
		newNum=0;
//		oldNum = oldNum + newNum;
		screen.setText(""+oldNum);
		System.out.println("Nums: " + oldNum + " " + newNum);
	}//eql method
	
	public static void num(String i){
		int x=0;
		boolean s=true;
//		System.out.println("eActionCommand" + i);
		
		switch (i){
		case "0":
			x = 0;
			break;
		case "1":
			x = 1;
			break;
		case "2":
			x = 2;
			break;
		case "3":
			x = 3;
			break;
		case "4":
			x = 4;
			break;
		case "5":
			x = 5;
			break;
		case "6":
			x = 6;
			break;
		case "7":
			x = 7;
			break;
		case "8":
			x = 8;
			break;
		case "9":
			x = 9;
			break;
		default:
			s = false;
			break;
		}
		
		System.out.println("x: " + x + " " + s);
		
		if (s){
			if (!firstTime){
				oldNum = oldNum*10 + x;
				screen.setText(""+oldNum);
				System.out.println("oldnum: " + oldNum);
			} else {
				newNum = newNum*10 + x;
				screen.setText(""+newNum);
				System.out.println("newnum: " + newNum);
			}
		}
		firstTime = true;
	}//num method

}//TI82 class //////////////////////////////////////////////////////////////////////////////////////////////////////

class clear implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		Calc.clear();
	}
}//clear method
class eql implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		Calc.eql();
	}
}//eql method

class operAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
//		Calc.firstTime = true;
		String i = e.getActionCommand();
		
		Calc.add=false;
		Calc.sub=false;
		Calc.mul=false;
		Calc.div=false;
		
		switch (i){
		case "+":
			Calc.add=true;
			break;
		case "-":
			Calc.sub=true;
			break;
		case "*":
			Calc.mul=true;
			break;
		case "/":
			Calc.div=true;
		break;
		default:
			System.out.println("ERROR");
		}
		System.out.printf("operAction: Sub is %s, add is %s, mul is %s, div is %s\n",Calc.sub,Calc.add,Calc.mul,Calc.div);
		Calc.eql.doClick();
		Calc.num(e.getActionCommand());
	}
}//operAction class
class numAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		Calc.num(e.getActionCommand());
//		System.out.println(e.getActionCommand());
	}//actionPerformed method
}//numAction class