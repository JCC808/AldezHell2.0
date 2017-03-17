import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by John8 on 3/13/2017.
 */
public class Level extends Rectangle{

    public ArrayList<Walls> walls;
    public ArrayList<GravityTiles> gravs;
    private Color color = Color.white;

    public void drawWalls(String textFile) throws IOException{
        int[] arr = read(textFile);
        int locx = 0, locy = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1)walls.add(new Walls(locx * 40, locy * 40,40,40,color));
            if (locx < 15){
                locx++;
            }else{
                locx = 0;
                locy++;
            }
        }
    }
    private int[] read(String fileName)throws IOException {
        int[] arr = new int[192];
        FileReader file = new FileReader(fileName);
        int i=0;
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            arr[i]= input.nextInt();
            i++;
        }
        return arr;
    }
    public void setColor(Color color){this.color = color;}
}
