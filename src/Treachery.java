import java.awt.*;
import java.io.IOException;

/**
 * Ninth Circle
 *
 * Created by John8 on 3/13/2017.
 */
public class Treachery extends Level{
    public Treachery()throws IOException{
        setColor(Color.black);
        drawWalls("resources/Level8.txt");
        drawLevelTiles();
        startx = 600;
        starty = 440;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(0,440,true));
        levs.add(new LevelTiles(40,320,false));
        levs.add(new LevelTiles(40,200,false));
        levs.add(new LevelTiles(240,80,false));
        levs.add(new LevelTiles(200,280,false));
        levs.add(new LevelTiles(320,240,false));
        levs.add(new LevelTiles(320,360,false));
        levs.add(new LevelTiles(480,440,false));
    }
    @Override
    public void render(Graphics g){
        if (LevelTiles.badColor != Color.black) LevelTiles.setBadColor(Color.black);
        super.render(g);
    }
}
