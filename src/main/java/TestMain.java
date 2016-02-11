
public class TestMain {
	public static void main(String[] args){
		Parser p = new Parser(args[0]);
		
		p.parse();
		
		p.printStuff();
	}
}
