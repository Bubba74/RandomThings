import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import javax.swing.*;


public class Fight {
	
	
private static Scanner input = new Scanner(System.in);
private static String Name1;
private static double Hp1Total = 20;
private static double Hp1;
private static int Hp1Width;
private static double Attack1 = 3;
private static double Defense1 = 3;
private static int Speed1 = 3;
private static String Name2 = "Enemy";
private static double Hp2Total = 12;
private static double Hp2;
private static int Hp2Width;
private static double Attack2 = 4;
private static double Defense2 = 3;
private static int Speed2 = 3;
public static boolean mobDead = false;
public static boolean youDead = false;
private static JFrame frame1 = new JFrame ("!Battle!");
private static int width;
private static int height;
private static JButton button1 = new JButton ("--EXIT--");
private static JButton button2 = new JButton ("--Attack--");
//private static JButton button3 = new JButton ("");
private static JTextArea txtArea1 = new JTextArea ();
private static JTextArea txtArea2 = new JTextArea ();
private static JPanel Health1 = new JPanel();
private static JPanel Health2 = new JPanel();





public static void main (String Args[]){
print("What is your name?");
Name1 = input.nextLine().toString();
Hp1 = Hp1Total;
Hp2 = Hp2Total;
frame1.setLayout(null);
frame1.setSize(800, 500);
frame1.setLocation(400, 250);
frame1.setResizable(false);
frame1.setAlwaysOnTop(true);
frame1.setEnabled(true);
frame1.setVisible(true);
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame1.getContentPane().setBackground(Color.lightGray);
width = frame1.getWidth();
height = frame1.getHeight();
button1.setBounds(width/8*5,height/8*5,width/4,height/4);
button1.setToolTipText("Save and Quit?");
button1.setBackground(Color.orange);
button1.setForeground(Color.magenta);
button1.setEnabled(true);
button1.setVisible(true);
button1.addActionListener(new actionExit());
frame1.add(button1);
txtArea1.setBounds(30,30,120,120);
update("txtArea1");
txtArea1.setBackground(Color.pink);
txtArea1.setVisible(true);
txtArea1.setEnabled(true);
frame1.add(txtArea1);
txtArea2.setBounds(frame1.getWidth()-135 , 30 , 120 , 120);
update("txtArea2");
txtArea2.setBackground(Color.pink);
txtArea2.setVisible(true);
txtArea2.setEnabled(true);
frame1.add(txtArea2);
button2.setBounds(width/8,height/8*5,width/4,height/4);
button2.setToolTipText("Attack?");
button2.setBackground(Color.orange);
button2.setForeground(Color.magenta);
button2.setEnabled(true);
button2.setVisible(true);
button2.addActionListener(new actionAttack());
frame1.add(button2);
Health1.setLocation(txtArea1.getX(), txtArea1.getY()+txtArea1.getHeight()+10);
Health1.setSize(txtArea1.getWidth(), 30);
Hp1Width = Health1.getWidth();
updateHealth("Health1");
Health1.setBackground(Color.green);
Health1.setEnabled(true);
Health1.setVisible(true);
Health1.setToolTipText("Health");
frame1.add(Health1);
Health2.setLocation(txtArea2.getX(), txtArea2.getY()+txtArea2.getHeight()+10);
Health2.setSize(txtArea2.getWidth(), 30);
Hp2Width = Health2.getWidth();
updateHealth("Health2");
Health2.setBackground(Color.green);
Health2.setEnabled(true);
Health2.setVisible(true);
Health2.setToolTipText("Health");
frame1.add(Health2);
}//main method
public static void updateHealth(String bar){
if (bar.equals("Health1")){
//frame1.setVisible(false);
//frame1.setEnabled(false);
Health1.setEnabled(false);
Health1.setVisible(false);
double percent;
Color bgColor;
percent = Hp1/Hp1Total;
if (percent <= .1){
bgColor = Color.red;
} else if (percent <= .5){
bgColor = Color.orange;
} else {bgColor = Color.green;}
Health1.setBackground(bgColor);
Health1.setSize((int) (Hp1Width*percent), 30);
Health1.setEnabled(true);
Health1.setVisible(true);
//frame1.setVisible(true);
//frame1.setEnabled(true);
}
if (bar.equals("Health2")){
frame1.setVisible(false);
frame1.setEnabled(false);
Health2.setEnabled(false);
Health2.setVisible(false);
double percent;
Color bgColor;
percent = Hp2/Hp2Total;
if (percent <= .1){
bgColor = Color.red;
} else if (percent <= .5){
bgColor = Color.orange;
} else {bgColor = Color.green;}
Health2.setBackground(bgColor);
Health2.setSize((int) (Hp2Width*percent), 30);
Health2.setEnabled(true);
Health2.setVisible(true);
frame1.setVisible(true);
frame1.setEnabled(true);
}
}
public static void update (String text){
if (text.equals("txtArea1")){
disable(txtArea1);
txtArea1.setText( Name1 +
"\nHealth = " + Hp1 +
"\nAttack = " + Attack1 +
"\nDefense = " + Defense1 +
"\nSpeed = " + Speed1);
enable(txtArea1);
}
if (text.equals("txtArea2")){
disable(txtArea2);
txtArea2.setText(Name2 +
"\nHealth = " + Hp2 +
"\nAttack = " + Attack2 +
"\nDefense = " + Defense2 +
"\nSpeed = " + Speed2);
enable(txtArea2);
}
}
public static void DamageDealt (){
double damage1, damage2;
damage1 = Attack2/Defense1;
damage2 = Attack1/Defense2;
Hp1 -= damage1;
Hp2 -= damage2;
if (Hp1 <= 0){
youDead = true;
}
if (Hp2 <= 0){
mobDead = true;
}
Hp1 = Math.floor(Hp1*100)/100;
Hp2 = Math.floor(Hp2*100)/100;
update("txtArea1");
update("txtArea2");
updateHealth("Health1");
updateHealth("Health2");
}
public static void enable (JTextArea txtArea){
txtArea.setEnabled(true);
txtArea.setVisible(true);
}
public static void disable (JTextArea txtArea){
txtArea.setEnabled(false);
txtArea.setVisible(false);
}
public static void wait(int time){
try {
TimeUnit.SECONDS.sleep(time);
} catch(InterruptedException e){}
}
public static void exit (){
frame1.setEnabled(false);
frame1.setVisible(false);
System.exit(0);
}//exit method
public static void print (String text){
System.out.println(text);
} public static void print (int text){
System.out.println("" + text);
}//print method(s)
}//Fight Class
class actionExit implements ActionListener {
@Override
public void actionPerformed (ActionEvent e){
Fight.exit();
}//actionPerformed method
}//actionExit class
class actionAttack implements ActionListener {
@Override
public void actionPerformed (ActionEvent e){
Fight.DamageDealt();
if (Fight.mobDead){
System.out.println("YOU WIN!!!");
Fight.exit();
}
if (Fight.youDead){
System.out.println("YOU LOSE!!!");
Fight.exit();
}
}//actionPerformed method
}//actionAction class
