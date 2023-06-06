import java.util.Scanner;

public class Dealer {
    //Constant to guess
    private static int randomNumber;
    //Flag to determine the number was guessed
    private boolean isRightNumber;
    //Array of all the players
    private Player[] playerArray;
    //Scanner to
    private Scanner myScanner = new Scanner(System.in);

    //CONSTRUCTOR method: Receives a number to be guessed and sets the flag to false
    public Dealer(int Number)
    {
        this.randomNumber = Number;
        this.isRightNumber = false;
    }

    //Starts game
    public void startGame() {

        System.out.println("Welcome to the game!\nLet's begin.");

        this.numberOfPlayers();

        System.out.println("Let's start guessing!");
    }

    public void endGame(){
        System.out.println("Congratulations!!!\nGoodbye!");

        this.myScanner.close();

        for(int i=0; this.playerArray.length<1;i++){
            this.playerArray[i].getMyScanner().close();
        }
    }

    //Creates an array the size of the number of players entered by the user
    private void numberOfPlayers(){
        System.out.println("How many players are you: ");
        int playerAmount = Integer.parseInt(this.myScanner.nextLine());

        this.playerArray = new Player[playerAmount];

        createPlayers(playerAmount);
    }

    //Fills in the array of players with Player instances
    private void createPlayers(int playerAmount){

        for (int i = 0; i < playerAmount; i++)
        {
            //Dealer.clearScreen();
            System.out.println("Player #" + (i+1)  + ": ");
            String playerName = this.myScanner.nextLine();

            this.playerArray[i] = new Player(playerName);
        }
    }

    public void game() {
        int playerGuess=0;
        while (!this.isRightNumber)
            for (Player players : this.playerArray) {

                //Dealer.clearScreen();
                System.out.println(players.getName() + "'s turn: ");

                playerGuess=players.guessNumber();
                while (playerGuess > 20 || playerGuess < 1) {

                            System.out.println("Try a number between 1 and 20");
                            playerGuess=players.guessNumber();
                }

                this.isRightNumber = this.isRightGuess(playerGuess, players.getName());

                if (this.isRightNumber) {
                    break;
                }
            }
    }

    //Evaluates the guessed number from certain player
    private boolean isRightGuess(int playerGuess, String playerName)
    {
        if (playerGuess == randomNumber)
        {
            System.out.println(playerName + " guessed the right number.");
            return true;
        }
        else{
            System.out.println("Wrong guess " + playerName + "\n");
            return false;
        }

    }
    /*public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }*/


}
