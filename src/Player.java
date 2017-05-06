import java.awt.*;
import java.util.Scanner;

/**
 * Created by John8 on 3/13/2017.
 */
public class Player extends Rectangle {
    public boolean cheat = true;
    public boolean w = false, a = false, s = false, d = false, space, nextLevel = false;
    private boolean down = true, up = true, left = true, right = true, reset = false;
    private int count = 0;
    private double dx = 0, dy = 0;
    public int gravity = 0,speed = 1,startx = 600,starty = 440;

    public Player(int x, int y) {
        setBounds(x, y, 16, 16);
        space = false;
    }

    public void next() {
        nextLevel = true;
    }
    public void reset(){
        x = startx;
        y= starty;
        gravity = 0;
    }

    public void tick(Level level) {
        //this crazy looking, really hard to read for loop is the hit boxes for the blocks
        for (int four = 0; four < 4; four++) {
            int twice = 0;
            //change
            if(cheat) {
                for (int i = 0; i < level.walls.size() && twice < 2; i++) {

//I know it looks messy but it works so leave it alone, or ask before changing this
//this checks every one of the 192 possible boxes on all sides.
// then tells the rest of the method which direction it cant move in
                    if ((this.getMaxY() >= level.walls.get(i).getMinY()) && (this.getMaxY() < level.walls.get(i).getMinY() + 4) &&
                            (this.getMaxX() > level.walls.get(i).getMinX()) && (this.getMinX() < level.walls.get(i).getMaxX())) {
                        down = false;
                        twice += 1;
                    }
                    if ((this.getMinY() >= level.walls.get(i).getMaxY()) && (this.getMinY() < level.walls.get(i).getMaxY() + 1) &&
                            (this.getMaxX() > level.walls.get(i).getMinX()) && (this.getMinX() < level.walls.get(i).getMaxX())) {
                        up = false;
                        twice += 1;
                    }
                    if ((this.getMaxX() >= level.walls.get(i).getMinX()) && (this.getMaxX() < level.walls.get(i).getMinX() + 4) &&
                            (this.getMaxY() > level.walls.get(i).getMinY()) && (this.getMinY() < level.walls.get(i).getMaxY())) {
                        right = false;
                        twice += 1;
                    }
                    if ((this.getMinX() >= level.walls.get(i).getMaxX()) && (this.getMinX() < level.walls.get(i).getMaxX() + 1) &&
                            (this.getMaxY() > level.walls.get(i).getMinY()) && (this.getMinY() < level.walls.get(i).getMaxY())) {
                        left = false;
                        twice += 1;
                    }

                }
            }
//this checks the edges
            if (x >= 624) right = false;
            if (x <= 0) left = false;
            if (y >= 464) down = false;
            if (y <= 0) up = false;


//normal change in location based off of key depression
// this also doesn't allow you do speed up or slow down your descent caused by gravity
            if (gravity == 1) {
                if (!right) reset = true;
                d = false;
                a = false;
                dx += speed;
            }
            if (gravity == 2) {
                if (!down) reset = true;
                w = false;
                s = false;
                dy +=speed;
            }
            if (gravity == 3) {
                if (!left) reset = true;
                d = false;
                a = false;
                dx -=speed;
            }
            if (gravity == 4) {
                if (!up) reset = true;
                s = false;
                w = false;
                dy -=speed;
            }
            if (a) dx -=speed;
            if (d) dx +=speed;
            if (w) dy -=speed;
            if (s) dy +=speed;

            if (space && reset) {
                if (gravity == 1) dx = -speed;
                if (gravity == 2) dy = -speed;
                if (gravity == 3) dx = speed;
                if (gravity == 4) dy = speed;
                count++;
                if(count == 50) {
                    count = 0;
                    space = false;
                    reset = false;
                }
            }
//it it cant move in a direction but it wants to... this says no...
            if (!right && dx > 0) dx = 0;
            if (!left && dx < 0) dx = 0;
            if (!down && dy > 0) dy = 0;
            if (!up && dy < 0) dy = 0;
//the actual change in (x,y)
            x += dx;
            y += dy;
//resets all of the values, ready for another method call.
//I know i could define them just for the method, but i didn't...
//change it if it bothers you that much
            up = true;
            down = true;
            left = true;
            right = true;
            dy = 0;
            dx = 0;
        }
    }
    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(x,y,width,height);
    }
}
