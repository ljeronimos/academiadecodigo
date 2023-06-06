public class Main {
    public static void main(String[] args){

        Dealer dealer = new Dealer((int)(Math.random()*(19-0) + 1));

        dealer.startGame();

        dealer.game();
        
        dealer.endGame();
    }
}
