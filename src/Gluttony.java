import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Third Circle
 *
 * Created by Juhyoung 2 on 5/10/2017.
 */
public class Gluttony extends Level{

    public static Box box = new Box(600, 50);
    public static Player player = new Player(600, 440);
    public ArrayList<GlutGrav> glutGrav = new ArrayList<>();
    public ArrayList<GlutTile> glutTile = new ArrayList<>();

    public Gluttony() throws IOException{
        drawWalls("resources/Level2.txt");
        drawGravTiles();
        drawLevelTiles();
        drawGlutTile();
        startx = 572;
        starty = 412;
    }
    private void drawLevelTiles(){
        levs.add(new LevelTiles(0,0,true));
    }
    private void drawGravTiles(){
        glutGrav.add(new GlutGrav(600, 360, 2));
        glutGrav.add(new GlutGrav(600, 440, 3));
        glutGrav.add(new GlutGrav(520, 440, 4));
        glutGrav.add(new GlutGrav(520, 360, 1));
    }
    private void drawGlutTile(){
        glutTile.add(new GlutTile(1, 1, true));
    }

    public void render(Graphics g) {
        box.render(g);
        for(GlutTile a: glutTile)a.render(g);
        super.render(g);
        for(GlutGrav a: glutGrav)a.render(g);
    }

    public void tick(Player player) {
        super.tick(player);
        for(GlutGrav a: glutGrav)a.tick(player, box);
        for(GlutTile a: glutTile)a.tick(player);
        for(LevelTiles lev: levs)lev.tick(player);
        box.tick(this);
        if(box.intersects(player)){
            box.reset();
            player.reset();
        }
//        if(player.nextLevel){
//            player.reset();
//            player.nextLevel = false;
//        }
    }
}
