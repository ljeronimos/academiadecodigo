package org.academiadecodigo.sharpshoorts.Objetos;

public class ArmouredEnemy extends Enemy{
    private int armour=50;

    public void hit(int value){

        if(this.armour>0){
            this.armour-=value;
        }else {
            if(!isDestroyed() && super.getHealth()>0)
                super.setHealth(super.getHealth()-value);
            else{
                this.killShot();
            }
        }
    }

    public String getMessage(){
        return "Armoured Enemy!";
    }
}
