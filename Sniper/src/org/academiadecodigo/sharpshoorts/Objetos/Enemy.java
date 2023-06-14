package org.academiadecodigo.sharpshoorts.Objetos;

abstract public class Enemy extends GameObject implements Destroyable{

    private int health=100;
    private boolean isDestroyed=false;


    public boolean isDestroyed(){
        return isDestroyed;
    }

    abstract public void hit(int value);

    public String getMessage(){
        return "I'm an enemy!";
    }
    public int getHealth(){return health;}
    public void setHealth(int health){this.health=health;}

    public void killShot(){
        this.isDestroyed=true;
    }
}
