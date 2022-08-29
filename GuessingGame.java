import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public int number;
    Random r = new Random();

    public GuessingGame() {
        this.number = 100 + r.nextInt(999);
    }

    public void playGame(){
        System.out.println("Welcome to number guessing game! " + "\n" +
                "The task is to guess the right random generated number ranging from 100-999" + "\n" +
                "You have 3 guesses. if any of your input is right. it will be marked with an 'X' if its wrong it will be marked with 'O'");
        Scanner sc = new Scanner(System.in);
        int guesses = 3;

        while(guesses > 0){
            System.out.println("Enter 3 digit number from 100 to 999");
            int guess = sc.nextInt();
            if(validateGuess(guess)){
                if(Integer.toString(guess).equals(Integer.toString(this.number))){
                    System.out.println("Secret number - " + this.number + "\n" +
                            "Your guess - " + guess + "\n" +
                            "Congratulations you won!!!!!");
                    guesses = 0;
                }else{
                    guesses--;
                    iterateGuess(guess);
                    System.out.println("Guesses left - " + guesses);
                    if(guesses == 0){
                        System.out.println("Your out off guesses type 'a' to play again or 'x' to quit");
                        String input = sc.next();
                        switch (input){
                            case "a":
                                guesses = 3;
                                break;
                            case "x":
                                System.out.println("The secret number was - " + this.number);
                                System.out.println("Quitting");
                        }
                    }
                }


            }else{
                System.out.println("Wrong input. Enter 3 digit number from 100 to 999");
                guess = sc.nextInt();
            }


        }
    }

    public void iterateGuess(int guessnr){

            StringBuilder temp = new StringBuilder("");
            for(int x = 0; x < Integer.toString(this.number).length(); x++){
                if(Integer.toString(guessnr).charAt(x) == Integer.toString(this.number).charAt(x)){
                    temp.append("X");
                }else{
                    temp.append("O");
                }
            }
            System.out.println("X represents correct guess. O represents wrong guess.");
            System.out.println(temp);
        }



    public boolean validateGuess(int guessnr){
        if(guessnr < 99 || guessnr > 999){
            return false;
        }
        return true;
    }
}
