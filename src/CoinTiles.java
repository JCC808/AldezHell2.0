import java.awt.*;

/**
 * Created by John8 on 3/16/2017.
 */
public class CoinTiles extends Rectangle{
    public static int count = 0;
    public static boolean pair = true;
    private boolean pare = true;
    private boolean visible = true;

    public CoinTiles(int x, int y) {
        setBounds(x, y,20, 20);
    }
    public void render(Graphics g){
        if(visible) {
            g.setColor(Color.yellow);
            g.fillOval(x, y, width, height);
        }
    }
    public void tick(Player player){
        if (pare!=pair){
            pare = !pare;
            visible = true;
        }
        if (visible && player.intersects(this)){
            count++;
            visible = false;
        }
        if (count > 2){
            count = 0;
            player.reset();
            pair = !pair;
            pare = !pare;
            visible = true;
        }
    }
}
