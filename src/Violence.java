import java.awt.*;
import java.io.IOException;
import java.util.*;
/**
 * Seventh Circle
 *
 * I think Leah wanted to make this one bloody ☺
 *
 * Created by John8 on 3/13/2017.
 */
public class Violence extends Level{
    public ArrayList<WrathLevelTiles> violenceTiles = new ArrayList<>();
    public Violence() throws IOException {
        drawWalls("resources/Level6.txt");
        drawLevelTiles();
        drawViolenceLevelTiles();
        startx = 12;
        starty = 12;
    }
    //put here
    private void drawLevelTiles(){
        levs.add(new LevelTiles(480,0,true));
    }
    private void drawViolenceLevelTiles(){
        violenceTiles.add(new WrathLevelTiles(1,120, false, false));
        violenceTiles.add(new WrathLevelTiles(80,40, false, false));
        violenceTiles.add(new WrathLevelTiles(80,360, false, true));
        violenceTiles.add(new WrathLevelTiles(400,120, false, false));
        violenceTiles.add(new WrathLevelTiles(160,160, false, true));
        violenceTiles.add(new WrathLevelTiles(160,360, false, true));
        violenceTiles.add(new WrathLevelTiles(240,240, false, false));
        violenceTiles.add(new WrathLevelTiles(360,360, false, true));
        violenceTiles.add(new WrathLevelTiles(440,360, false, false));
        violenceTiles.add(new WrathLevelTiles(560,200, false, true));
        violenceTiles.add(new WrathLevelTiles(240,240, false, false));
        violenceTiles.add(new WrathLevelTiles(600,1, false, true));
    }
    @Override
    public void render(Graphics g) {
        super.render(g);
        for (WrathLevelTiles vi : violenceTiles) vi.render(g);
    }
    @Override
    public void tick(Player player) {
        super.tick(player);
        for(WrathLevelTiles vi : violenceTiles)vi.tick(player);
    }
}
