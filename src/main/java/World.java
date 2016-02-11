
public class World {
	int rows, cols, droneNum, maxTurns, maxPay;
	
	int[] prodWeights;
	Warehouse[] warehouses;
	
	Order[] orders;
	Drone[] drones;
	
	int[][] map;
	
	public World(){
		
	}
	
	public static void main(String[] args){
		Parser p = new Parser(args[0]);
		World world = new World();
		
		p.parse(world);
		
		//p.printStuff();
	}
}
