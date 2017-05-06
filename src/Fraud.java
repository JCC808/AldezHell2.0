import java.io.IOException;

/**
 * Eighth Circle
 *
 * Created by John8 on 3/13/2017.
 */
public class Fraud extends Level{
    public Fraud() throws IOException{
        drawWalls("resources/Level7.txt");
        drawLevelTiles();
        startx = 612;
        starty = 452;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(120,40,true));
    }
}
