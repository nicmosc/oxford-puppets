import java.util.*;
import java.io.*;

public class Parser {
	
	int rows, cols, droneNum, maxTurns, maxPay;
	
	String filename;
	
	int[] prodWeights;
	Warehouse[] warehouses;
	
	Order[] orders;
	
	public Parser(String f){
		filename = f;
	}
	
	public void parse(){
		int i = 0;
        String line = null;
        int prodNum;
        int wareCounter = 0;
        
        int orderNum;
        int internalCounter = 0;
        int orderCounter = 0;
        
        System.out.println("sidjf");
        
        try{

            File filescan = new File(filename);;

            FileReader f = new FileReader(filescan);

            BufferedReader fileReader = new BufferedReader(f);

            while((line = fileReader.readLine()) != null)
            {
            	String[] vals = line.split(" ");
            	
                if(i==0)    
                {
                	rows = Integer.parseInt(vals[0]);
                	cols = Integer.parseInt(vals[1]);
                	
                	droneNum = Integer.parseInt(vals[2]);
                	
                	maxTurns = Integer.parseInt(vals[3]);
                	maxPay = Integer.parseInt(vals[4]);
                }
                
                else if (i == 1){
                	prodWeights = new int[Integer.parseInt(line)];
                }
                
                else if (i == 2){
                	for(int j = 0; j < prodWeights.length; j++){
                		prodWeights[j] = Integer.parseInt(vals[j]);
                	}
                }
                
                else if (i == 3){
                	warehouses = new Warehouse[Integer.parseInt(line)];
                }
                
                else if (i < 2*warehouses.length+4){
                	
                	if(i % 2 == 0){
                		warehouses[wareCounter] = new Warehouse(Integer.parseInt(vals[0]),Integer.parseInt(vals[1]));
                		wareCounter++;
                	}
                	else{
                		for(int j = 0; j < vals.length; j++){
                			if(!vals[j].equals("0")){
                				warehouses[wareCounter-1].scoredProds.put(j, Integer.parseInt(vals[j]));
                			}
                		}
                	}
                	
                }
                
                //HERE DO THE ORDER STUFFF !!!
                
                else if(i == 2*warehouses.length+4){
            		//orderNum = Integer.parseInt(line);
                	orders = new Order[Integer.parseInt(line)];
            		
            	}
                
                else {
	
                	internalCounter ++;
                	
                	if (internalCounter == 1){	//location
                		//System.out.println("123");
                		orders[orderCounter] = new Order(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]));	
                	}
                	else if (internalCounter == 2){	// number of items
                		orders[orderCounter].productTypes = new int[Integer.parseInt(line)];
                	}
                	else { // type
                		int[] temp = orders[orderCounter].productTypes;
                		for(int j = 0; j < temp.length; j++){
                			temp[j] = Integer.parseInt(vals[j]);
                		}
                		
                		internalCounter = 0;
                		orderCounter ++;
                	}
                	
                	
                }
                
                i++;
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening file!");
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file!");
        }
	}
	
	public void printStuff(){
		System.out.println(rows + " " + cols + " " + droneNum + " " + maxTurns + " " + maxPay);
		
		System.out.println(prodWeights[0] + " " + prodWeights[1] + " " + prodWeights[2]);
		
		System.out.println(warehouses.length);
		
		for(int x = 0; x < warehouses.length; x++){
			warehouses[x].printInfo();
			System.out.println(x);
		}
		
		for(int x = 0; x < orders.length; x++){
			orders[x].printInfo();
			//System.out.println(x);
		}
	}
}
