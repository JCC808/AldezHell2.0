import java.io.IOException;

/**
 * Seventh Circle
 *
 * I think Leah wanted to make this one bloody ☺
 *
 * Created by John8 on 3/13/2017.
 */
public class Violence extends Level{
    public Violence() throws IOException {
        drawWalls("resources/Level6.txt");
        drawLevelTiles();
        startx = 12;
        starty = 452;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(600,240,true));
    }
}
