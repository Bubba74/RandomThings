package Objects;

public class ObjectMain {
	
//	private static Operation math = new Operation();
	
	public static void main (String Args[]){
		//Possible operations: add, sub, mult, div

		
//		System.out.printf("Answer: %s", math.polynomial("1,3,2","*","1,4,6,4,1"));
		
//		int[] polyA = {2,0};
//		int[] polyB = {1,2};
//		System.out.printf("Answer: %s", math.polynomial(polyA, "*", polyB));
		System.out.println("he");
		Rectangle rect = new Rectangle();
		rect.setX(50);
		Rectangle rect2 = new Rectangle();
		rect2.setX(150);
		
		System.out.println(rect.getX());
		System.out.println(rect2.getX());
		rect.setX(49);
		rect2.setX(149);
		System.out.println(rect.getX());
		System.out.println(rect2.getX());
		
		
		
		
	}//main method
}//ObjectMain class