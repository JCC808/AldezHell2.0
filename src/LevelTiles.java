import java.awt.*;

/**
 * Created by John8 on 5/5/2017.
 */
public class LevelTiles extends Rectangle {

    private boolean type;
    private Color color;

    public LevelTiles(int x,int y, boolean type){
        setBounds(x,y,40,40);
        this.type = type;
        if (type) color = Color.green;
        else color = Color.red;
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
        g.setColor(color);
        g.fillOval(x,y,width,height);
    }

}
