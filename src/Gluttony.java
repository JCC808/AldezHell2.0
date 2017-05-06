import java.io.IOException;

/**
 * Third Circle
 *
 * Created by John8 on 3/13/2017.
 */
public class Gluttony extends Level{
    public Gluttony() throws IOException{
        drawWalls("resources/Level2.txt");
        drawLevelTiles();
        startx = 572;
        starty = 412;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(0,0,true));
    }
}
