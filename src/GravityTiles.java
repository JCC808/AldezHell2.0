import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 * Created by John8 on 3/15/2017.
 */
public class GravityTiles extends Rectangle {
    private int gravDirection;
    private BufferedImage img;
    public GravityTiles(int x, int y, int gravDirection) {
        if (gravDirection == 0) {
            setBounds(x,y,10,10);
            this.gravDirection = gravDirection;
        } else {
            setBounds(x, y, 40, 40);
            this.gravDirection = gravDirection;

            try {
                if (gravDirection == 1) img = ImageIO.read(new File("resources/pictures/ArrowRight.png"));
                if (gravDirection == 2) img = ImageIO.read(new File("resources/pictures/ArrowDown.png"));
                if (gravDirection == 3) img = ImageIO.read(new File("resources/pictures/ArrowLeft.png"));
                if (gravDirection == 4) img = ImageIO.read(new File("resources/pictures/ArrowUp.png"));
            } catch (IOException e) {
            }
        }
    }
    public int getGravDirection(){
        return gravDirection;
    }

    public void tick(Player player){
        if (!(player.gravity == gravDirection) && player.intersects(this)) player.gravity = gravDirection;
    }

    public void render(Graphics g){
        if (gravDirection>0) {
            g.drawImage(img, x, y, null);
        }else{
            g.fillRect(x,y,width,height);
        }
    }
}
