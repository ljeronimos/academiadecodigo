import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    public static int screenWidth;
    public static int screenHeight;
    private int delay;
    private Picture rubberDuck;
    private Target target;

    public Game(int screenWidth, int screenHeight, int delay){
        this.screenWidth=screenWidth;
        this.screenHeight=screenHeight;
        this.delay=delay;
    }

    public void init () {

        Rectangle background = new Rectangle(10,10,screenWidth,screenHeight);
        background.draw();

        background.setColor(Color.DARK_GRAY);
        background.fill();

        rubberDuck = new Picture(0,0,"/home/luis/Desktop/AC/myRepo (git inside)/academiadecodigo/SimpleGraphicsTest/Resources/kisspng-rubber-duck-clip-art-5ad8820ae62835.6217414815241385069427.png");
        rubberDuck.grow(-903,-700);
        rubberDuck.translate(-600,-400);

        target = new Target(rubberDuck);

        target.draw();

        new Handler(target);

    }

    public void start() throws InterruptedException {

        while (true){

            Thread.sleep(delay);

            target.moveRandom();


        }



    }



}
