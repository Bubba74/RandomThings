import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.J

public class VIM {
	
	JFrame frame = new JFrame ("Workspace");
	JPanel panel = new JPanel ();
	
	
	public static void main (String Args[]){
		print("Welcome to your workspace!");
		print("Here you are able to create and edit files.");

		doNow();
		
	}//main method
	
	public static void doNow (){
		
		
		
	}//doNow method
	
	public static void print (String text){
		System.out.println(text);
	}//print method
	
	public static void space (int num){
		String lines = "";
		
		for (int i = 1; i < num; i++){
			lines += "\n";
		}
		print(lines);
		
	}//space method
	
	public static void exit (){
		System.exit(0);
	}
	
}//VIM class
