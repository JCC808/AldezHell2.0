import java.awt.*;

/**
 * Created by John8 on 3/13/2017.
 */
public class Walls extends Rectangle{
    public Walls(int x, int y,int width, int height){
        setBounds(x,y,width,height);
    }
    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,width,height);
    }
}
