import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Fourth Circle
 *
 * Created by John8 on 3/13/2017.
 */
public class Greed extends Level{

    private ArrayList<CoinTiles> coins = new ArrayList();

    public Greed() throws IOException{
        drawWalls("resources/Level3.txt");
        drawCoins();
        drawLevelTiles();
        startx = 612;
        starty = 12;
    }
    private void drawCoins(){}
    private void drawLevelTiles(){
        levs.add(new LevelTiles(0,0,true));
    }
    @Override
    public void tick(Player player) {
        super.tick(player);
        for(CoinTiles coin: coins)coin.tick(player);
    }
    @Override
    public void render(Graphics g){
        super.render(g);
        for(CoinTiles coin: coins)coin.render(g);
    }
}
