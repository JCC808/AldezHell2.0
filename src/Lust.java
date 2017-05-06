import java.io.IOException;

/**
 * second circle
 *
 * Created by John8 on 3/13/2017.
 */
public class Lust extends Level{
    public Lust()throws IOException {
        drawWalls("resources/Level1.txt");
        drawLevelTiles();
        startx = 612;
        starty = 12;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(0,200,true));
    }
}
