

/**
 * Created by John8 on 5/6/2017.
 */
public class WrathLevelTiles extends LevelTiles {
    private boolean up;
    private int move = 1;
    public WrathLevelTiles(int x, int y, boolean type, boolean up){
        super(x,y,type);
        width = 38;
        height = 38;
        this.up = up;
    }

    @Override
    public void tick(Player player) {
        super.tick(player);
        for(Walls wall: Game.levels.get(Game.level).walls){
            if (this.intersects(wall)){
                move = -move;
            }
        }
        if (x >= 602) move = -move;
        if (x <= 0) move = -move;
        if (y >= 442) move = -move;
        if (y <= 0) move = -move;
        if(up){
            y += move;
        }else{
            x+= move;
        }

    }
}
