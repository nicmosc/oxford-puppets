import java.util.*;
import java.io.*;

public class Main
{
    static String param;
    
    public static void main(String[] args){
        
        //put args[0] when finished, for now use test value
        param = args[0];
        Painting painting = new Painting(param+".in");
        
        
        //METHOD USING ONLY LINE DRAWING (draw line by line)
        
        painting.printmap();
        
        lineByLineHorizontal(painting);

        //UNCOMMENT THE FOLLOWING TO TEST SOLUTION
        
        //painting.resetMap();
        
        //painting.printmap();
        
        //painting.scanSolution(param+".txt");
        
        //System.out.println();
        
        //painting.printmap();
        
    }
    
    public static void lineByLineHorizontal(Painting paint){
        
        // paint line requires 2 coordinates R1 C1 R2 C2
        
        ArrayList<Quatruple> commandCoords = new ArrayList<Quatruple>();
        
        int r1 = 0;
        int c1 = 0;
        int r2 = 0;
        int c2 = 0;
        boolean inLine = false;
        
        for(int r = 0; r < paint.map.length; r++){ //for each row
            
            for(int c = 0; c < paint.map[r].length; c++){ //for each element in row
                
                if(paint.map[r][c] == '#' && !inLine){ //when we start a line
                   r1 = r;
                   c1 = c;
                   inLine = true;
                }
                
                if(paint.map[r][c] == '.' && inLine){ //when we finish a line
                    r2 = r;
                    c2 = c-1;
                    inLine = false;
                    
                    commandCoords.add(new Quatruple(r1, c1, r2, c2));
                    
                }
                
            }
            
            if(inLine){
                r2 = r;
                c2 = paint.map[r].length - 1;
                
                commandCoords.add(new Quatruple(r1, c1, r2, c2));
            }
           
            inLine = false; // reset when starting a new line
        }
        
        /*System.out.println(commandCoords.size());
        for(int i = 0; i<commandCoords.size(); i++){
            System.out.println("PAINT_LINE " + commandCoords.get(i).r1 + " " + commandCoords.get(i).c1 + " " +
                commandCoords.get(i).r2 + " " + commandCoords.get(i).c2);
        }
        
        System.out.println();
        System.out.println("Total number of cells: " + paint.row * paint.col);
        System.out.println("Total score: " + (paint.row * paint.col - commandCoords.size()));*/
        
        try{
            PrintWriter writer = new PrintWriter("res/"+param+".txt", "UTF-8");
            
            writer.println(commandCoords.size());
            
            for(int i = 0; i<commandCoords.size(); i++){
                writer.println("PAINT_LINE " + commandCoords.get(i).r1 + " " + commandCoords.get(i).c1 + " " +
                    commandCoords.get(i).r2 + " " + commandCoords.get(i).c2);
            }
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
    }
}
