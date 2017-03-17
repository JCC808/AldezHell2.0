import java.awt.*;

/**
 * Created by John8 on 3/16/2017.
 */
public class CoinTiles extends Rectangle{

    public CoinTiles(int x, int y) {
        setBounds(x, y,16, 16);
    }
    public void render(Graphics g){
        g.setColor(Color.green);
        g.fillOval(x,y,width,height);
    }
}
