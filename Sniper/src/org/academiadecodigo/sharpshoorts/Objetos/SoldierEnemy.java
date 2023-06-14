package org.academiadecodigo.sharpshoorts.Objetos;

public class SoldierEnemy extends Enemy{

    public void hit(int value){
        if(!isDestroyed() && super.getHealth()>0)
            super.setHealth(super.getHealth()-value);
        else{
            this.killShot();
        }
    }

    public String getMessage(){
        return "Soldier Enemy!";
    }
}
