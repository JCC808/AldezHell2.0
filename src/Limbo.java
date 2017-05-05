import java.io.IOException;

/**
 * first circle
 *
 * Created by John8 on 3/13/2017.
 */
public class Limbo extends Level{
    public Limbo()throws IOException{
        drawWalls("resources/Level0.txt");
        drawGravTiles();
    }
    public void drawGravTiles(){
        gravs.add(new GravityTiles(600, 0, 2));
        gravs.add(new GravityTiles(520, 200, 3));
        gravs.add(new GravityTiles(0, 440, 4));
        gravs.add(new GravityTiles(160, 440, 1));
        gravs.add(new GravityTiles(480, 360, 1));
    }
}
