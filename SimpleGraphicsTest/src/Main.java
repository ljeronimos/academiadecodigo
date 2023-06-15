import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.security.PublicKey;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final int SCREEN_WIDTH=1280;
        final int SCREEN_HEIGHT=720;
        final int DELAY=100;

        Game g = new Game(SCREEN_WIDTH,SCREEN_HEIGHT,DELAY);

        g.init();
        g.start();

    }
}
