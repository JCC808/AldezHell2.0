import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by John8 on 3/13/2017.
 */
public class Game extends Canvas implements Runnable, KeyListener {
    private boolean isRunning = false;
    public static int level = 5;
    private Thread thread;
    public static ArrayList<Level> levels = new ArrayList<>();
    private Player player;
    private static final int WIDTH = 640, HEIGHT = 480;
    private static Color backColor = Color.black;


    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Scanner scan = new Scanner(System.in);
        JFrame frame = new JFrame();
        frame.setTitle("Adlez");
        frame.add(game);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();

    }

    public Game() throws IOException {
        Dimension dimension = new Dimension(Game.WIDTH, Game.HEIGHT);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        addKeyListener(this);
        levels.add(new Limbo());
        levels.add(new Lust());
        levels.add(new Gluttony());
        levels.add(new Greed());
        levels.add(new Wrath());
        levels.add(new Heresy());
        levels.add(new Violence());
        levels.add(new Fraud());
        levels.add(new Treachery());
        player = new Player(600, 440);
    }
    private void tick() {
        if(player.nextLevel){
            level++;
            player.startx = levels.get(level).startx;
            player.starty = levels.get(level).starty;
            player.reset();
            player.nextLevel=false;
        }
        levels.get(level).tick(player);
        player.tick(levels.get(level));
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(backColor);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        levels.get(level).render(g);
        player.render(g);
        g.dispose();
        bs.show();
    }

    public synchronized void start() {
        if (isRunning) return;
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!isRunning) return;
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setBackColor(Color color){backColor = color;}

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') player.d = true;
        if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') player.a = true;
        if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') player.w = true;
        if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') player.s = true;
        if (e.getKeyChar() == ' ') player.space = true;
        if (e.getKeyChar() == 'O') player.cheat = false;
        if (e.getKeyChar() == 'P') player.cheat = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') player.d = false;
        if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') player.a = false;
        if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') player.w = false;
        if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') player.s = false;
        if (e.getKeyChar() == ' ') player.space = false;
    }

    @Override
    public void run() {
        double lastTime = System.nanoTime();
        double targetTick = 60.0;
        double ns = 1000000000 / targetTick;
        double delta = 0;
        requestFocus();
        while (isRunning) {
            double now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
    }
}
