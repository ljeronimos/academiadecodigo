import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Handler implements KeyboardHandler {

    public Keyboard keyboard;
    public Target target;


    public Handler(Target target){
        this.target = target;
        this.keyboard = new Keyboard(this);
        createKeyboardEvents();
    }

    public Handler(Picture picture){


    }

    public void createKeyboardEvents(){
        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(keyboardEventSpace);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_RIGHT:
                target.moveRight();
                break;
            case KeyboardEvent.KEY_LEFT:
                target.moveLeft();
                break;
            case KeyboardEvent.KEY_UP:
                target.moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                target.moveDown();
                break;
            case KeyboardEvent.KEY_SPACE:
                System.exit(1);
                break;
                /*Rectangle rectangle = new Rectangle((int) (Math.random()*600),(int) (Math.random()*600),40,40);
                rectangle.fill();*/
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
