import java.awt.*;
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
        startx = 52;
        starty = 452;
    }
    private void drawLevelTiles(){
        levs.add(new HeresyLevelTiles(600,0,true));    //make this one a false red
        levs.add(new LevelTiles(40,0,false));
        levs.add(new LevelTiles(40,360,false));
        levs.add(new LevelTiles(200,280,false));
        levs.add(new LevelTiles(280,40,false));
        levs.add(new LevelTiles(360,120,false));
        levs.add(new LevelTiles(360,400,false));
        levs.add(new LevelTiles(440,240,false));
        levs.add(new LevelTiles(480,40,false));
        levs.add(new LevelTiles(480,360,false));
        levs.add(new LevelTiles(600,240,false));
        levs.add(new LevelTiles(600,480,false));
        levs.add(new HeresyLevelTiles(0,0,false));    //make this one a false green
    }
}
