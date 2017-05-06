import java.awt.*;
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
        frauds.add(new FraudLevelTiles(0,240,false));
        frauds.add(new FraudLevelTiles(0,400,false));
        frauds.add(new FraudLevelTiles(120,160,false));
        frauds.add(new FraudLevelTiles(120,320,false));
        frauds.add(new FraudLevelTiles(240,0,false));
        frauds.add(new FraudLevelTiles(320,440,false));
        frauds.add(new FraudLevelTiles(400,0,false));
        frauds.add(new FraudLevelTiles(480,440,false));
        frauds.add(new FraudLevelTiles(560,0,false));

    }
    public static void remove(){
        frauds.remove(frauds.size()-1);
    }

    public void render(Graphics g) {
        super.render(g);
        for (FraudLevelTiles fraud : frauds) fraud.render(g);
    }
}
