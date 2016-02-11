import javax.vecmath.Vector2d;

public class Order {
	int[] productTypes;
	
	Vector2d location;
	
	public Order(int x, int y){
		location = new Vector2d(x,y);
	}
	
	public void printInfo(){
		System.out.println(location);
		
		for(int i = 0; i<productTypes.length; i++){
			System.out.print(productTypes[i] + " ");
		}
		System.out.println();
	}
}
