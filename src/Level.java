import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by John8 on 3/13/2017.
 */
public class Level{

    public ArrayList<Walls> walls = new ArrayList<>();
    public ArrayList<GravityTiles> gravs = new ArrayList<>();
    public ArrayList<LevelTiles> levs = new ArrayList<>();
    public int startx,starty;
    private Color color = Color.cyan;

    public Level(){}

    public void drawWalls(String textFile) throws IOException{
        int[] arr = read(textFile);
        int locx = 0, locy = 0;
        for (int i = 0; i < 192; i++) {
            if (arr[i] == 1) walls.add(new Walls(locx * 40, locy * 40, 40, 40, color));
            if (locx < 15) {
                locx++;
            } else {
                locx = 0;
                locy++;
            }
        }
    }

    private int[] read(String fileName)throws IOException {
        int[] arr = new int[192];
        FileReader file = new FileReader(fileName);
        int i=0;
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            arr[i]= input.nextInt();
            i++;
        }
        return arr;
    }

    public void setColor(Color color){this.color = color;}

    public void tick(Player player){
        for(GravityTiles grav : gravs)grav.tick(player);
        for(LevelTiles lev: levs)lev.tick(player);
    }

    public void render(Graphics g){
        for (Walls wall: walls) wall.render(g);
        for (GravityTiles grav: gravs) grav.render(g);
        for (LevelTiles lev : levs ) lev.render(g);
    }
}
