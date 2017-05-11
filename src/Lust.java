import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * second circle
 *
 * Created by John8 on 3/13/2017.
 */
public class Lust extends Level{
    public ArrayList<LustLevelTiles> lusts = new ArrayList();
    public static Mirror mirror = new Mirror(40,240);

    public Lust()throws IOException {
        drawWalls("resources/Level1.txt");
        drawLustLevelTiles();
        startx = 584;
        starty = 240;
    }
    private void drawLustLevelTiles(){
        lusts.add(new LustLevelTiles(0,200,true,true));
        lusts.add(new LustLevelTiles(560,200,true,false));
    }

    @Override
    public void tick(Player player) {
        super.tick(player);
        for(LustLevelTiles lust: lusts)lust.tick(player);
        mirror.tick(this);
        if (mirror.intersects(player)){
            mirror.reset();
            player.reset();
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        for(LustLevelTiles lust: lusts)lust.render(g);
        mirror.render(g);
    }
}
