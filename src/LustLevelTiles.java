/**
 * Created by John8 on 5/6/2017.
 */
public class LustLevelTiles extends LevelTiles{
    private boolean side;
    private static boolean play = false, mir = false;
    public LustLevelTiles(int x, int y, boolean type,boolean side){
        super(x,y,type);
        this.side = side;
        width=80;
        height=80;
    }

    @Override
    public void tick(Player player) {
        if (side){
            if (!mir)play=false;
            if (player.intersects(this)){
                if(type){
                    play=true;
                }else{
                    player.reset();
                }
            }
        }else{
            if (!play)mir=false;
            if(Lust.mirror.intersects(this)){
                if(type){
                    mir=true;
                }else{
                    player.reset();
                }
            }
        }
        if (mir&&play) player.next();
    }
}
