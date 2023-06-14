package org.academiadecodigo.sharpshoorts;

import org.academiadecodigo.sharpshoorts.Objetos.*;

public class Game {

    GameObject[] gameObjects;
    SniperRifle sniper;
    int shotsFired;

    public void start(int numObj){

        System.out.println("Create array of "+numObj+" objects");
        createObjects(numObj);

        System.out.println("Create Sniper with 20 of Damage");
        sniper = new SniperRifle(20);

        //Print array
        for(int i=0;i<gameObjects.length;i++){
            System.out.println(gameObjects[i].getMessage());
        }

        for (GameObject o : gameObjects){
            if(o instanceof Destroyable){
                //System.out.println(o.getMessage());
                sniper.shoot((Destroyable) o);
            }else {
                o.getMessage();
            }
        }
    }

    public GameObject[] createObjects(int numObj){

        gameObjects = new GameObject[numObj];

        for(int i=0; i<numObj;i++){
            if(Math.random()<0.2)
                this.gameObjects[i] = new Tree();
            else{
                double random = Math.random();
                if(random<0.3)
                    this.gameObjects[i] = new SoldierEnemy();
                else if(random>0.3 && random<0.6)
                    this.gameObjects[i] = new ArmouredEnemy();
                else {
                    double random2 = Math.random();
                    if (random2<0.3)
                        this.gameObjects[i] = new Barrel(BarrelType.PLASTIC); //PLASTIC
                    else if (random2>0.3 && random2<0.6)
                        this.gameObjects[i] = new Barrel(BarrelType.WOOD); //WOOD
                    else
                        this.gameObjects[i] = new Barrel(BarrelType.METAL); //METAL
                }
            }

        }
        return this.gameObjects;
    }
}
