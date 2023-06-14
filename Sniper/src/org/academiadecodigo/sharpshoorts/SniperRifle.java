package org.academiadecodigo.sharpshoorts;

import org.academiadecodigo.sharpshoorts.Objetos.Destroyable;
import org.academiadecodigo.sharpshoorts.Objetos.GameObject;

public class SniperRifle {
    private int bulletDamage;

    public SniperRifle(int damage){
        this.bulletDamage = damage;
    }
    public void shoot(Destroyable target){

        int numShots=0;

        while (!target.isDestroyed()){
            target.hit((int)(Math.random()*bulletDamage));
            numShots++;
        }
        System.out.println(target.getMessage()+" took "+(numShots-1)+" shots to die.");
    }
}
