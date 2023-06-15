import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args){

        Rectangle background = new Rectangle(10,10,600,600);
        background.draw();

        //Limit 10,10,600,600
        background.setColor(Color.GREEN);

        Picture picture = new Picture(0,0,"/Users/codecadet/IdeaProjects/SimpleGraphicsTest/Resources/kisspng-rubber-duck-clip-art-5ad8820ae62835.6217414815241385069427.png");
        picture.grow(-903,-700);
        picture.translate(-600,-400);

        Player player = new Player(picture);

        player.draw();

        new Handler(player);

        //Picture picture = new Picture(10,10,"/Users/codecadet/IdeaProjects/SimpleGraphicsTest/Resources/kisspng-rubber-duck-clip-art-5ad8820ae62835.6217414815241385069427.png");
        System.out.println("Height: "+picture.getHeight()+" Width: "+picture.getWidth());
        System.out.println("x: "+picture.getX()+" y: "+picture.getY());

    }
}
