import java.util.Scanner;

// make miley test it to find bugs

public class guessMyNumber {
    
    public static void main (String args[]) {

        lineBreak();
        System.out.println("Welcome to Guess My Number! Where I pick a number between [x,y] and you guess until you get it correct [or you give up ;)] lets begin! ");
        Scanner s = new Scanner(System.in);
        boolean active = true; 

        while(active) {
            lineBreak();

            System.out.print("Enter a lower bound: ");
            while(!s.hasNextInt()) {
                s.next();
                System.out.print("That is not a proper integer, try again. Enter a lower bound: ");
            }
            int lowerBound = s.nextInt();
            int upperBound = 0;

            System.out.print("Enter an upper bound: ");
            boolean noBounds = true;
            while (noBounds) {
                while(!s.hasNextInt()) {
                    s.next();
                    System.out.print("That is not a proper integer, try again. Enter an upper bound: ");
                }
                upperBound = s.nextInt();
                if (upperBound <= lowerBound) {
                    System.out.print("Enter an upper bound larger than your lower bound: ");
                } else {
                    noBounds = false;
                }
            }

            System.out.print(boxText("generating random number... done!"));

            int number = (int)Math.floor(Math.random() *(upperBound - lowerBound + 1) + lowerBound);
            System.out.println("\nRandom Number: " + number);

            int index = 1; 
            int guess = lowerBound - 10; 
            while(guess != number) {
                System.out.print("Enter guess #" + index + ": ");
            
                while(!s.hasNextInt()) {
                    s.next();
                    System.out.print("That is not a proper integer, try again. Enter a guess: ");
                }
        
                guess = s.nextInt();

                if(guess > upperBound || guess < lowerBound) {
                    System.out.println("Out of Bounds!");
                } else if(guess > number) {
                    System.out.println("Too high!");
                } else if (guess < number) {
                    System.out.println("Too low!");
                } 
                index++;
            }

            System.out.println("Good job! You guessed the number! Would you like to play again? ");
            System.out.print("Please enter 'y' to continue (or 'n' to exit): ");
            String cont = s.next();
            boolean inconclusive = true; 
            while(inconclusive) {
                if(cont.equals("y")) {
                    active = true;
                    inconclusive = false;
                }
                else if (cont.equals("n")) {
                    active = false;
                    inconclusive = false;
                }
                else {
                    System.out.print("Try again, pick y/n to continue or exit, respectively: ");
                    cont = s.next();
                }
            }
        }

        lineBreak();
        System.out.println("Thanks for playing Guess My Number! Goodbye!");
        s.close();
        lineBreak();
    }

    public static void lineBreak() {
        System.out.println ("\n + ********** + \n");
    }

    public static String boxText(String s) {
        String horizontal = " ";
        String vertical = "|";
        for(int i = 0; i < s.length() + 1; i++)
        {
            horizontal = horizontal + "-";
            vertical = vertical + " ";
        }
        horizontal = horizontal + "\n";

        return horizontal + "|" + s + "|\n" + horizontal;
    }

}
