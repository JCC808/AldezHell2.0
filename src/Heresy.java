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
        startx = 12;
        starty = 452;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(600,0,true));
        //make this one a false red
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
        levs.add(new LevelTiles(40,0,false));
        levs.get(12) //make this one a false green
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        if (type) {
            g.setColor(goodColor);
            g.fillOval(x, y, width, height);
        }else{
            g.setColor(badColor);
            g.fillOval(x, y, width, height);
    }
}
