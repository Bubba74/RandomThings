package Graphics;
//////////////////IMPORTS/////IMPORTS/////IMPORTS/////IMPORTS////////////////////
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



/////////////////CLASS////////CLASS///////CLASS///////CLASS//////////////////////
public class Main{
	
	public static JFrame f;
	public static paint graphics;
	public static Action upAction, downAction, rightAction, leftAction, spaceAction;
	public static boolean upOpen, downOpen, rightOpen, leftOpen;
	public static int objects[][];
	public static boolean jump = false;
	public static boolean crouch = false;
	public static boolean swing = false;
//////////////////METHODS/////METHODS/////METHODS/////METHODS////////////////////
	public static void main (String Args[]){
		
		createGUI();
		loadActions();
		startKeyListeners();
	}//main method
	
	public static void createGUI (){
		
		graphics = new paint();
		
		f = new JFrame ("Jumping?");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(graphics);
		f.pack();
		
		f.setSize(800,500);
		f.setLocation(700,300);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.setVisible(true);

		
	}//createGUI method

	public static void startKeyListeners(){
		
		int condition = JPanel.WHEN_IN_FOCUSED_WINDOW;
		InputMap im = graphics.getInputMap(condition);
		ActionMap am = graphics.getActionMap();
		
		im.put(KeyStroke.getKeyStroke("UP"),"upKey");
		im.put(KeyStroke.getKeyStroke("DOWN"),"downKey");
		im.put(KeyStroke.getKeyStroke("RIGHT"),"rightKey");
		im.put(KeyStroke.getKeyStroke("LEFT"),"leftKey");
		im.put(KeyStroke.getKeyStroke("SPACE"), "spaceKey");

		am.put("upKey", upAction);
		am.put("downKey", downAction);
		am.put("rightKey", rightAction);
		am.put("leftKey", leftAction);
		am.put("spaceKey", spaceAction);
		
	}//startKeyListeners method
	
	public static void loadActions() {

		upAction = new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e){
				new Thread() {
			        public void run() {
			        	checkArea();
			        	if (upOpen){
			        		if(!jump){
			        			jump = true;
//			        			jump();
			        			jump2();
			        			jump = false;
			        		}
			        	}
			        }
			    }.start();
			}
		};
		downAction = new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				new Thread() {
			        public void run(){
			        	if (!crouch){
			        		crouch = true;
//			        		crouch();
			        		crouch2();
			        		crouch = false;
			        	}
			        }
			    }.start();
			}
		};
		rightAction = new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				checkArea();
				if (rightOpen){
					graphics.RectX += 10;
					graphics.repaint();					
				}
			}
		};
		leftAction = new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				checkArea();
				if (leftOpen){
					graphics.RectX -= 10;
					graphics.repaint();
				}
			}
		};
		spaceAction = new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				new Thread() {
					public void run(){
						if(!swing){
							swing = true;
							swing();
							swing = false;
						}
					}
				};
			}
		};
		
	}//loadActions method
	
	public static void jump(){
		graphics.RectY -= 25;
		graphics.repaint();
		wait(240);
		graphics.RectY -= 25;
		graphics.repaint();
		wait(240);
		wait(200);
		graphics.RectY += 25;
		graphics.repaint();
		wait(240);
		graphics.RectY += 25;
		graphics.repaint();
		wait(240);
	}//jump method
	public static void jump2(){
		graphics.RectY -= 10;
		graphics.repaint();
	}//jump2 method
	public static void crouch (){

		graphics.RectY += 10;
		graphics.repaint();
		wait(500);
		graphics.RectY -= 10;
		graphics.repaint();
	}
	public static void crouch2(){
		graphics.RectY += 10;
		graphics.repaint();
		
	}//crouch2 method
	public static void swing(){
		
		
	}//swing method
	public static void addObject(int x,int y,int width,int height,int objectNum){
		int xStart, xEnd, yStart, yEnd;
		xStart = x-5;
		xEnd = x+width+5;
		yStart = y-5;
		yEnd = y+height+5;
		
		objects[objectNum][0] = xStart;
		objects[objectNum][1] = xEnd;
		objects[objectNum][2] = yStart;
		objects[objectNum][3] = yEnd;

	}//addObject method
	public static void checkArea(){
		upOpen = true;
		downOpen = true;
		rightOpen = true;		
		leftOpen = true;

		int x = graphics.RectX;
		int y = graphics.RectY;
		
		
		
		
		for (int i = 0; i<objects.length;i++){
				
				if (x>=objects[i][0] && x<=objects[i][1]&&y>=objects[i][3]){
					upOpen = false;
				}
//				if (x>=objects[i][0] && x<=objects[i][1]&&y>=objects[i][4]){
//					downOpen = false;
//				}
//				if (x>=objects[i][0] && x<=objects[i][1]&&y>=objects[i][4]){
//					rightOpen = false;
//				}
//				if (x>=objects[i][0] && x<=objects[i][1]&&y>=objects[i][4]){
//					leftOpen = false;
//				}
				
			
		}

	}//leftOpen method

	
	public static void wait (int time){
		try {
			TimeUnit.MILLISECONDS.sleep(time);
		} catch (InterruptedException e){}
		
	}//wait method
	
}//Main class