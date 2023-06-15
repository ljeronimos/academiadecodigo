import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Picture player;

    public Player(Picture player){
        this.player=player;
    }

    public void draw(){
        player.draw();
    }

    public void moveRight(){
        player.translate(10,0);
    }

    public void moveLeft(){
        player.translate(-10,0);
    }

    public void moveUp(){
        player.translate(0,-10);
    }

    public void moveDown(){
        player.translate(0,10);
    }
}
