import java.util.*;
import javax.vecmath.Vector2d;

public class Warehouse {
	Vector2d location;
	
	HashMap<Integer, Integer> scoredProds; 
	
	public Warehouse(int x, int y){
		location = new Vector2d(x, y);
		
		scoredProds = new HashMap<Integer, Integer>(); // index to amount, weight
	}
	
	public void printInfo(){
		System.out.println(location);
		System.out.println(scoredProds);
	}
}
