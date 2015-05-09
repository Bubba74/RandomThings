import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
public class KeyListener {
public static JFrame frame = new JFrame();
public static JPanel panel;
public static JLabel image;
public static void main (String Args[])throws IOException{
frame.setVisible(true);
frame.setEnabled(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocation(50,50);
frame.setLayout(null);
frame.getContentPane().setBackground(Color.lightGray);

String src = "/home/henry/javaPics/stickFigure.png";
File path = new File (src);
BufferedImage buffer = ImageIO.read(path);
image = new JLabel (new ImageIcon(buffer));

image.setEnabled(true);
image.setVisible(true);
image.setToolTipText("Meet Bob");
image.setSize(100,140);
image.setLocation(30,30);
Action upAction = new AbstractAction(){
public void actionPerformed(ActionEvent e){
// KeyListener.panel.setBackground(Color.green);
image.setLocation ((int)(image.getLocation().getX()),(int) (image.getLocation().getY() - 5));
}
};
Action downAction = new AbstractAction(){
public void actionPerformed(ActionEvent e){
// KeyListener.panel.setBackground(Color.cyan);
image.setLocation ((int)(image.getLocation().getX()),(int) (image.getLocation().getY() + 5));
}
};
Action leftAction = new AbstractAction(){
public void actionPerformed(ActionEvent e){
// KeyListener.panel.setBackground(Color.red);
image.setLocation ((int)(image.getLocation().getX() - 5),(int) (image.getLocation().getY()));
}
};
Action rightAction = new AbstractAction(){
public void actionPerformed(ActionEvent e){
// KeyListener.panel.setBackground(Color.orange);
image.setLocation ((int)(image.getLocation().getX() + 5),(int) (image.getLocation().getY()));
}
};
panel = new JPanel();
panel.setSize(frame.getMaximumSize());
panel.setBackground(Color.darkGray);
panel.setLayout(null);
panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up");
panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "up");
panel.getActionMap().put("up", upAction);
panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down");
panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "down");
panel.getActionMap().put("down", downAction);
panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "left");
panel.getActionMap().put("left", leftAction);
panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "right");
panel.getActionMap().put("right", rightAction);
panel.add(image);
frame.add(panel);
frame.pack();
frame.setSize(1200, 700);
}
}