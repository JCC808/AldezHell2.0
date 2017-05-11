/**
 * Created by Juhyoung Lee 2 on 5/10/2017.
 */
public class GlutGrav extends GravityTiles {
    public GlutGrav(int x, int y, int dir){
        super(x, y, dir);
    }

    public void tick(Player player, Box box){
        if (!(box.gravity == getGravDirection()) && player.intersects(this)) box.gravity = getGravDirection();
        player.setGravity(0);
    }
}
