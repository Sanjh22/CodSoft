import java.util.Random;
import java.util.Scanner;

public class Task_1_NumberGuessingGame {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // Creating instance of Random()--> for generating a random number
        Random ran = new Random();
        int randomNum = ran.nextInt(100) + 1;

        // Creating a Scanner() class--> for taking input from users
        Scanner sc = new Scanner(System.in);

        // Number Guessing Game
        while (true) {
            System.out.print("Enter your Number :");
            int num = sc.nextInt();

            if (num == randomNum) {
                System.out.println("Congrats ! You Won ");
                break;
            } else if (num > randomNum) {
                System.out.println("Your guess is too high! Try Again");
            } else {
                System.out.println("Your guess is too low! Try Again");
            }
        }
    }
}
