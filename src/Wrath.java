import java.io.IOException;

/**
 * Fifth Circle
 *
 * I claim this one, im gonna make it really hard!! ☺
 *
 * Created by John8 on 3/13/2017.
 */
public class Wrath extends Level{
    public Wrath() throws IOException {
        drawWalls("resources/Level4.txt");
        drawLevelTiles();
        startx = 12;
        starty = 452;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(600,240,true));
    }
}
