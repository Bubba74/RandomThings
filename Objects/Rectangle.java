package Objects;

public class Rectangle {
	
	private int x;
	int y;
	int width;
	int height;
	
	int level;
	public static final int PRIMARY = 0;
	public static final int SECONDARY = 1;
	public static final int TERTIARY = 2;
	
	boolean canMove;
	float r;
	float g;
	float b;
	
	public void setX(int i){
		x = i;
	}//setX method
	public int getX(){
		return this.x;
	}
}
