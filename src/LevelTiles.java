import java.awt.*;

/**
 * Created by John8 on 5/5/2017.
 */
public class LevelTiles extends Rectangle {

    private boolean type;
    private static Color goodColor, badColor;

    public LevelTiles(int x,int y, boolean type){
        setBounds(x,y,40,40);
        this.type = type;
    }
    public void tick(Player player){
        if (player.intersects(this)){
            if(type){
                player.next();
            }else{
                player.reset();
            }
        }
    }
    public void render(Graphics g){
        if (type) {
            g.setColor(goodColor);
            g.fillOval(x, y, width, height);
        }else{
            g.setColor(badColor);
            g.fillOval(x, y, width, height);
        }
    }
    public static void setGoodColor(Color color){
        goodColor = color;
    }
    public static void setBadColor(Color color){
        badColor = color;
    }

}
