/**
 * Created by John8 on 5/6/2017.
 */
public class FraudLevelTiles extends LevelTiles {
    public FraudLevelTiles(int x, int y, boolean type){
        super(x,y,type);
    }

    @Override
    public void tick(Player player) {
        if (player.intersects(this)){
            if(type){
                player.next();
            }else{
                player.reset();
                Fraud.remove = true;
            }
        }
    }
}
