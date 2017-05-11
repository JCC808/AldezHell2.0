/**
 * Created by Juhyoung Lee 2 on 5/10/2017.
 */
public class GlutTile extends LevelTiles {
    private boolean side;
    private static boolean play = false, box = false;
    public GlutTile(int x, int y,boolean side){
        super(x,y,true); //assuming true is good and pass
        this.side = side;
        width=40;
        height=40;
    }

    @Override
    public void tick(Player player) {
        if(player.intersects(this)){
            player.reset();
            Gluttony.box.reset();
        }
        if(Gluttony.box.intersects(this)){
            player.next();
        }
        /**
        if (side){
            if (!box)play=false;
            if (player.intersects(this)){
                if(type){
                    play=true;
                }else{
                    player.reset();
                }
            }
        }else{
            if (!play)box=false;
            if(Gluttony.box.intersects(this)){
                if(type){
                    box=true;
                }else{
                    player.reset();
                }
            }
        }
        if (box&&play) player.next(); **/
    }
}
