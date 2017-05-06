import java.awt.*;
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
        wraths.add(new WrathLevelTiles(1,1, false, false));
        wraths.add(new WrathLevelTiles(240,120, false, false));
        wraths.add(new WrathLevelTiles(80,440, false, false));
        wraths.add(new WrathLevelTiles(320,240, false, true));
        wraths.add(new WrathLevelTiles(400,120, false, false));
        wraths.add(new WrathLevelTiles(400,320, false, true));
        wraths.add(new WrathLevelTiles(520,160, false, false));
        wraths.add(new WrathLevelTiles(480,400, false, false));
    }
    @Override
    public void render(Graphics g) {
        super.render(g);
        for (WrathLevelTiles wrath : wraths) wrath.render(g);
    }
    @Override
    public void tick(Player player) {
        super.tick(player);
        for(WrathLevelTiles wrath : wraths)wrath.tick(player);
    }
}
//bloop
