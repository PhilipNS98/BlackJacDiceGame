import java.util.*;

public class ExerciseBlackJackDiceGame{
    public static void main(String[] args){
        System.out.println("***WELCOME TO THE BLACK JACK DICE GAME!!!***");
        System.out.println("In the following exercise you will be making a Blackjack game where a human can play against a computer.");

        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        int userTotal = userThrows(console, rand);
        System.out.printf("You total was:%10d\n", userTotal);

        int machineTotal = machineThrows(rand, userTotal);
        System.out.printf("Machine total was:%6d\n", machineTotal);

        if (machineTotal >= userTotal && machineTotal < 21){
            System.out.println("Machine won!");
        } else if(machineTotal > 21 && userTotal < 21){
            System.out.println("You won!");
        } else if(machineTotal == 21){
            System.out.println("Machine got BlackJack! Machine win!");
        } else if(userTotal == 21){
            System.out.println("You got BlackJack! You win!");
        } else if(userTotal > 21){
            System.out.println("You exeded 21, Machine win!");
        } else if(userTotal < 21 && machineTotal < 21 && userTotal > machineTotal){
            System.out.println("You won!");
        } else if(userTotal == 21 && machineTotal == 21){
            System.out.println("You got BlackJack! You win!");
        }
    }
    public static int userThrows(Scanner console, Random rand){

        System.out.println("Do you want to roll the dice? y/n" );
        String go = console.next();
        int userSum = 0;

        while (go.equals("y") && userSum < 21){
            int rollA = rand.nextInt(6) + 1;
            System.out.printf("first dice roll:%8d\n", rollA);
            int rollB = rand.nextInt(6) + 1;
            System.out.printf("Second dice roll:%7d\n", rollB);
            userSum += rollA + rollB;
            System.out.printf("You have rolled:%8d\n", userSum);

            if (userSum == 21) {
                break;
            } else if (userSum > 21){
                break;
            } else {

            }
            System.out.printf("Your total is now on:%3d\n", userSum);
            System.out.println("Do you want to roll the dice again? y/n" );
            go = console.next();


        }
        return userSum;
    }
    public static int machineThrows(Random rand, int userSum){

        int machineSum = 0;

        while (machineSum <= 16){

            int rollA = rand.nextInt(6) + 1;
            int rollB = rand.nextInt(6) + 1;
            machineSum += rollA + rollB;

            if(userSum < 16 && machineSum > userSum){
                break;
            } else if (userSum > 21 && machineSum < 21){
                break;
            }


        }
        return machineSum;
    }
}
