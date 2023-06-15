package org.academiadecodigo.bootcamp88;

import org.academiadecodigo.bootcamp88.Exceptions.NotEnoughPermissionsException;

public class Main {
    public static void main(String[] args){

        FileManager fm = new FileManager();

        //THROWN ERROR: wrong password
        try {
            fm.login("12345");
        }catch (NotEnoughPermissionsException ex){
            System.out.println(ex.getMessage());

        }
    }
}
