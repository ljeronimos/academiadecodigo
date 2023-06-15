package org.academiadecodigo.bootcamp88;

import org.academiadecodigo.bootcamp88.Exceptions.FileNotFoundException;
import org.academiadecodigo.bootcamp88.Exceptions.NotEnoughPermissionsException;
import org.academiadecodigo.bootcamp88.Exceptions.NotEnoughSpaceException;

public class FileManager {

    private File[] fileArray;
    private String password="12345";

    public void login(String password) throws NotEnoughPermissionsException{

        if(!password.equals(this.password)){
            throw new NotEnoughPermissionsException("Wrong password!");
        }else {
            fileArray = new File[10];

            //THROWN ERROR: Create a new file outside of the array
            for (int i = 0; i <= fileArray.length; i++) {
                try {
                    createFile(i, "File_" + i);
                } catch (NotEnoughSpaceException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            //THROWN ERROR: Find file that does not exist
            try {
                File file = getFile("File_20");
                System.out.println(file.getName() + " found.");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public void logout(){

    }

    public File getFile(String str) throws FileNotFoundException {

        boolean ret = false;
        File fileFound=null;

        for(File f:fileArray){
            ret = f.getName().equals(str);

            if(ret) {
                fileFound = f;
                break;
            }
        }

        if(!ret){
            throw new FileNotFoundException("File not found!");
        }

        return fileFound;
    }

    public void createFile(int i,String name) throws NotEnoughSpaceException{

            if(i>=fileArray.length){
              throw new NotEnoughSpaceException("Not enough space in the array.");
            }else {
                this.fileArray[i] = new File(name);
            }



    }
}
