import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

public class MouseHandler implements org.academiadecodigo.simplegraphics.mouse.MouseHandler {

    public Mouse mouse;
    public Target target;

    public MouseHandler(){
        this.mouse = new Mouse(this);
        //createMouseEvents();
    }

    /*public void createMouseEvents(){

        MouseEvent mouseEventLeftClick = new MouseEvent(Game.screenHeight/2,Game.screenWidth/2);
        this.createMouseEvents();
        this.mouseClicked(mouseEventLeftClick);
        mouseEventLeftClick
    }*/

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
