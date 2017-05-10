import java.awt.*;

/**
 * Created by Juhyoung Lee 2 on 5/10/2017.
 */
public class Box extends Player {
    private int xstart, ystart;


    public Box(int x, int y){
        super(x, y);
        this.xstart = x;
        this.ystart = y;
        gravity = 0;
    }

    public void render(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x,y,width,height);
    }
    public void reset(){
        super.reset(600, 50);
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
                dx += speed;
            }
            if (gravity == 2) {
                dy +=speed;
            }
            if (gravity == 3) {
                dx -=speed;
            }
            if (gravity == 4) {
                dy -=speed;
            }

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
}
