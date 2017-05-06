import java.io.IOException;
import java.util.ArrayList;

/**
 * Fifth Circle
 *
 * I claim this one, im gonna make it really hard!! ☺
 *
 * Created by John8 on 3/13/2017.
 */
public class Wrath extends Level{
    public ArrayList<WrathLevelTiles> wraths = new ArrayList<>();
    public Wrath() throws IOException {
        drawWalls("resources/Level4.txt");
        drawLevelTiles();
        drawWrathLevelTiles();
        startx = 12;
        starty = 452;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(600,240,true));
    }
    private void drawWrathLevelTiles(){
        wraths.add(new WrathLevelTiles(0,0,true,true));
    }
}
