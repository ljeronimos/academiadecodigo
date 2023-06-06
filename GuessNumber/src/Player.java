import java.util.Scanner;

public class Player {

    //Player's  guess
    private int guess;
    //Player's name
    private String name;
    //Scanner to receive player's guess input
    private Scanner myScanner = new Scanner(System.in);

    //Constructor receives player name
    public Player(String player){
        this.name = player;
        this.guess = 0;
    }

    //Method to guess the number
    public int guessNumber () {

        //System.out.println("Player " + this.name + " guess the number");
        this.guess = Integer.parseInt(this.myScanner.nextLine());



        //System.out.println("Player "+this.name+" guessed: "+ this.guess);

        return guess;
    }

    //Getter to fetch player name
    public String getName(){
        return this.name;
    }

    public Scanner getMyScanner(){return this.myScanner;}

}
