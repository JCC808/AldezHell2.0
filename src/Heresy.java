import java.io.IOException;

/**
 * Sixth Circle
 *
 * Created by John8 on 3/13/2017.
 */
public class Heresy extends Level{
    public Heresy() throws IOException {
        drawWalls("resources/Level5.txt");
        drawLevelTiles();
        startx = 12;
        starty = 452;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(600,240,true));
    }
}
