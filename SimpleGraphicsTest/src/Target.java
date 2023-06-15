import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Target {

    private Picture target;
    private int stepsCount;
    public static final int MAX_STEPS=5;
    private Directions direction;

    public Target(Picture target){
        this.target = target;
        this.stepsCount=0;
        this.direction = Directions.values()[(int)(Math.random()*Directions.values().length)];
    }

    public void draw(){
        target.draw();
    }


    public void moveUp(){
        target.translate(0,-10);
    }
    public void moveUpRight(){
        target.translate(10,-10);
    }
    public void moveRight(){
        target.translate(10,0);
    }
    public void moveDownRight(){
        target.translate(10,10);
    }
    public void moveDown(){
        target.translate(0,10);
    }
    public void moveDownLeft(){
        target.translate(-10,10);
    }
    public void moveLeft(){
        target.translate(-10,0);
    }
    public void moveUpLeft(){
        target.translate(-10,-10);
    }



    public boolean hitsBorder(){

        switch (direction) {
            case WEST:
                if(target.getX()<20)
                    return true;
                break;
            case NORTH:
                if(target.getY()<20)
                    return true;
                break;
            case EAST:
                if((target.getMaxX()+10)>Game.screenWidth)
                    return true;
                break;
            case SOUTH:
                if((target.getMaxY()+10)>Game.screenHeight)
                    return true;
                break;
            case NORTHEAST:
                if(target.getY()<20 || (target.getMaxX()+10)>Game.screenWidth)
                    return true;
                break;
            case SOUTHEAST:
                if((target.getMaxX()+10)>Game.screenWidth || (target.getMaxY()+10)>Game.screenHeight)
                    return true;
                break;
            case SOUTHWEST:
                if((target.getMaxY()+10)>Game.screenHeight || target.getMaxX()<20)
                    return true;
                break;
            case NORTHWEST:
                if(target.getY()<20 || target.getX()<20)
                    return true;
                break;
            default:
                return false;
        }
        return false;
    }

    public void newDirection(){
        int random = (int)(Math.random()*Directions.values().length);
        direction = Directions.values()[random];
    }


    public void moveRandom(){

        while (hitsBorder())
            newDirection();

        switch (direction) {
            case NORTH -> moveUp();
            case NORTHEAST -> moveUpRight();
            case EAST -> moveRight();
            case SOUTHEAST -> moveDownRight();
            case SOUTH -> moveDown();
            case SOUTHWEST -> moveDownLeft();
            case WEST -> moveLeft();
            case NORTHWEST -> moveUpLeft();
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
        stepsCount++;

        if(stepsCount>MAX_STEPS) {
            newDirection();
            stepsCount=0;
        }

    }
}
