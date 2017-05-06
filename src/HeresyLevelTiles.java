import java.awt.*;

/**
 * Created by leahbianchi on 5/6/17.
 *
 * switches good and bad color
 */
public class HeresyLevelTiles extends LevelTiles {
    public HeresyLevelTiles(int x, int y, boolean type){
        super(x,y,type);
    }
    public void render(Graphics g) {
        if (type) {
            g.setColor(badColor);
            g.fillOval(x, y, width, height);
        } else {
            g.setColor(goodColor);
            g.fillOval(x, y, width, height);
        }
    }
}
