import java.io.IOException;
import java.util.ArrayList;

/**
 * Eighth Circle
 *
 * Created by John8 on 3/13/2017.
 */
public class Fraud extends Level{
    public static ArrayList<FraudLevelTiles> frauds = new ArrayList();
    public Fraud() throws IOException{
        drawWalls("resources/Level7.txt");
        drawLevelTiles();
        drawFraudLevelTiles();
        startx = 612;
        starty = 452;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(120,40,true));
    }
    private void drawFraudLevelTiles(){
        frauds.add(new FraudLevelTiles(40,0,false));
        //more
    }
    public static void remove(){
        frauds.remove(frauds.size()-1);
    }
}
