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
    //location of coins is the box location+10
    private void drawCoins(){
        coins.add(new CoinTiles(90, 90));
        coins.add(new CoinTiles(130, 170));
        coins.add(new CoinTiles(10, 250));
        coins.add(new CoinTiles(210, 370));
        coins.add(new CoinTiles(290, 130));
        coins.add(new CoinTiles(330, 250));
        coins.add(new CoinTiles(330, 450));
        coins.add(new CoinTiles(370, 210));
        coins.add(new CoinTiles(410, 90));
        coins.add(new CoinTiles(530, 370));
        coins.add(new CoinTiles(570, 90));
        coins.add(new CoinTiles(610, 250));

    }
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
