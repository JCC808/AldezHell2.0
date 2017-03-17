import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 * Created by John8 on 3/15/2017.
 */
public class GravityTiles extends Rectangle {
    private int gravDirection;
    public static int numTiles = 0;
    private BufferedImage img;
    public GravityTiles(int x, int y, int gravDirection){
        setBounds(x,y,40,40);
        this.gravDirection = gravDirection;
        numTiles++;

        try{
            if(gravDirection == 1) img = ImageIO.read(new File("resources/pictures/ArrowRight.png"));
            if(gravDirection == 2) img = ImageIO.read(new File("resources/pictures/ArrowDown.png"));
            if(gravDirection == 3) img = ImageIO.read(new File("resources/pictures/ArrowLeft.png"));
            if(gravDirection == 4) img = ImageIO.read(new File("resources/pictures/ArrowsUp.png"));
        } catch (IOException e){}
    }
    public int getGravDirection(){
        return gravDirection;
    }
    public static int getnumTiles(){
        return numTiles;
    }
    public void tick(){}
    public void render(Graphics g){
        g.drawImage(img,x,y,null);
    }
}
