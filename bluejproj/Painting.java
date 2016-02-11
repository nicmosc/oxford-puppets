import java.util.*;
import java.io.*;
import java.lang.*;

public class Painting {
    
    public char[][] map = null;
    
    public int row, col;
    
    public Painting(String p){
        String path = "res/"+p;
        scanFile(path);
        
    }
    
    public void resetMap(){
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[i].length;j++)
                map[i][j] = '.';
        }
    }

    public boolean checkSquare(int r,int c)
    {
        if(r>=0 && r<map.length && c>=0 && c<map[r].length)
            return true;
        else
            return false;
    }

    public void erase_cell(int r, int c)
    {
        if(checkSquare(r,c))
            map[r][c] = '.';
    }

    //      paint_square(8,15,5);
    public void paint_square(int r, int c, int s)
    {

        int range = 2*s + 1;

        if(checkSquare(r-s,c-s) && checkSquare(r+s,c+s))
            if(s>0)
            {
                for(int i=(r-s);i<(r-s)+range;i++)
                    for(int j=(c-s);j<(c-s)+range;j++)
                        map[i][j] = '#';
            }
            else
                map[r][c] = '#';
        else
            System.out.println("Out of range");
    }   


    public void paint_line(int r1,int c1,int r2,int c2)
    {
        if(c1 == c2 && checkSquare(r1,c1) && checkSquare(r2,c2))
        {
            for(int i = r1;i<=r2;i++)
                map[i][c1] = '#';
        }
        else if(r1==r2 && checkSquare(r1,c1) && checkSquare(r2,c2))
        {
            for(int i = c1;i<=c2;i++)
                map[r1][i] = '#';
        }
        else
            System.out.println("Out of range");

    }


    public void printmap()
    {
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[i].length;j++){
                
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    public boolean check()
    {
        boolean check = true;

        for(int i=0;i<map.length;i++)
            for(int j=0;j<map[  i].length;j++)
            {
                if(!(map[i][j] == '#'))
                    check = false;
            }

        return check;
    }

    public void scanFile(String filename)
    {
        int i = 0;
        String line = null;
        try{

            File filescan = new File(filename);;

            FileReader f = new FileReader(filescan);

            BufferedReader fileReader = new BufferedReader(f);

            while((line = fileReader.readLine()) != null)
            {
                if(i==0)    // read dimensions and create map
                {
                    String[] temp = line.split(" ");
                    row = Integer.parseInt(temp[0]);
                    col = Integer.parseInt(temp[1]);
                    map = new char[row][col];
                    line = fileReader.readLine();
                }

                Scanner scan = new Scanner(line);
                String temp = scan.next();
                char[] charline = temp.toCharArray();

                //System.out.println(charline);
                map[i] = charline;
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
    
    public void scanSolution(String path){
        String line = null;
        try{

            File filescan = new File("res/"+path);

            //System.out.println("res/"+path);
            FileReader f = new FileReader(filescan);

            BufferedReader fileReader = new BufferedReader(f);

            while((line = fileReader.readLine()) != null)
            {
                String[] data = line.split(" ");
                
                //System.out.println(data[0]); 
                
                if(data[0].equals("PAINT_LINE")){
                    
                    paint_line(Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]), 
                    Integer.parseInt(data[3]), 
                    Integer.parseInt(data[4]));
                }
                
                else{//implement other methods...
                }
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening file!");
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file!!!!");
        }

    }

}