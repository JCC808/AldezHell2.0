import java.awt.*;

/**
 * Created by John8 on 3/13/2017.
 */
public class Walls extends Rectangle{
    private Color color;
    public Walls(int x, int y,int width, int height, Color color){
        setBounds(x,y,width,height);
        this.color = color;
    }
    public void render(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
