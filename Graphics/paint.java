package Graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class paint extends JPanel {
	
	public static int RectX = 100;
	public static int RectY = 230;
	public static int oldRectX = RectY;
	public static int oldRectY = RectX;
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.green);
		this.setLocation(50, 20);
		this.setSize(700,430);
		
		g.setColor(this.getBackground());
		g.fillRect(oldRectX, oldRectY, 100, 100);//erases old rect
		g.setColor(Color.red);
		g.fillRect(RectX,RectY,100,100);//redraws rect in new location
		
////////////LOADS INTERACTIVE OBJECTS///////////////////
		int objectsNum = 2;
		Main.objects = new int[objectsNum][4];
		
		g.setColor(Color.orange);
		g.fillRect(300, 230, 100, 100);//test object 1
		Main.addObject(300, 230, 100, 100,0);
		
		g.setColor(Color.darkGray);
		g.fillRect(300, 100, 100, 100);//test object 2
		Main.addObject(300, 100, 100, 100,1);
		
		
//////////^^^^^^^^^^^^^^^^^^^^^^^^^^^^^/////////////////
		
		updateVars();
	}//paintComponent method
	
	public static void updateVars (){
		oldRectX = RectX;
		oldRectY = RectY;
		
	}//updateVar method
	
}//paint class
