import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {//  MAIN FUNCTION
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();// generate random no
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("\t_________________________________________________________________");
        System.out.println("\t\t\t\t\tTHE NUMBER GUESSING GAME");
        System.out.println("\t_________________________________________________________________");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int guess;

            System.out.println("\n\tTHE NUMBER IS IN BETWEEN " + minRange + " and " + maxRange);

            while (true) {
                System.out.print("\n\tNUMBER IS: ");// input of no
                guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber){     //correct --  EQUAL
                    System.out.println("\t\tCongratulations! ;) You guessed the correct number in " + attempts + " attempts..!");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (guess < targetNumber && guess>1){   //wrong -- LESS
                    System.out.println("\t\tToo low :( -- TRY AGAIN");
                } else if (guess > targetNumber && guess<100){   //wrong -- MORE
                    System.out.println("\t\tToo high :( -- TRY AGAIN");
                }
                else{// out of range wrong input
                    System.out.println("\t\t<<< ENTER NUMBER IN VALID RANGE >>>");
                }

                if (attempts == maxAttempts) {
                    System.out.println("\n\tSorry...! Better luck next time,\n\t The correct number was: " + targetNumber);
                    break;
                }

                if(attempts==5){// HINT if the no of attempts is
                    System.out.println("\n\t\t<<< HINT >>>");
                    if(hintNo(targetNumber))
                        System.out.println("\t\t/ NO IS ODD /");
                    else
                        System.out.println("\t\t/ NO IS EVEN /");

                }

            }

            System.out.print("Do you want to play again? (yes--1/no--0): ");//   continue

        } while (scanner.next().equalsIgnoreCase("1"));

        System.out.println("\t<< TOTAL SCORE is: " + score +" >>");//   score
        System.out.println("\tThank you for playing..!");
        scanner.close();
    }
    public static boolean hintNo(int no) {//    hint if the no is ODD or EVEN
        return(no%2!=0);
    }

}