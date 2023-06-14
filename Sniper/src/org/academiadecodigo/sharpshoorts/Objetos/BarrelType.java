package org.academiadecodigo.sharpshoorts.Objetos;

public enum BarrelType {
    PLASTIC(5),
    WOOD(10),
    METAL(20);

    int maxDamage;

    private BarrelType(int maxDamage){this.maxDamage=maxDamage;}

    public int getMaxDamage(){
        return maxDamage;
    }
}
