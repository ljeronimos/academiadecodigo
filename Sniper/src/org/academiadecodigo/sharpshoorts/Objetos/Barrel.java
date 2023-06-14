package org.academiadecodigo.sharpshoorts.Objetos;

public class Barrel extends GameObject implements Destroyable{
    private boolean isDestroyed=false;
    private BarrelType barrelType;
    private int currentDamage;

    public Barrel(BarrelType barrelType){
        this.barrelType = barrelType;
        this.currentDamage=0;
    }

    public boolean isDestroyed(){
        return isDestroyed;
    }

    public void hit(int points){

        if(currentDamage< barrelType.getMaxDamage()){
            currentDamage+=points;
        }
        else{
            this.isDestroyed=true;
        }
    }

    public String getMessage(){
        return barrelType+" barrel!";
    }
}
