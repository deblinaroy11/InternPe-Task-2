import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        int userScore = 0;
        int computerScore = 0;
        int rounds = 0;

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (rounds < 5) 
        {
            System.out.println("Round " + (rounds + 1));
            System.out.println("Enter your choice (rock, paper, or scissors):");
            String userChoice = scanner.nextLine().toLowerCase();

            if (!isValidChoice(userChoice, choices)) 
            {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                continue;
            }

            int randomIndex = random.nextInt(3);
            String computerChoice = choices[randomIndex];

            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chooses: " + computerChoice);

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);

            if (result.equals("You win!")) 
            {
                userScore++;
            } else if (result.equals("Computer wins!")) {
                computerScore++;
            }

            rounds++;
        }

        System.out.println("Game Over!");
        System.out.println("Your Score: " + userScore);
        System.out.println("Computer's Score: " + computerScore);

        if (userScore > computerScore)
         {
            System.out.println("You win the game!");
        } 
        else if (computerScore > userScore) {
            System.out.println("Computer wins the game!");
        } 
        else 
        {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    public static boolean isValidChoice(String choice, String[] validChoices)
     {
        for (String validChoice : validChoices)
         {
            if (choice.equals(validChoice))
             {
                return true;
            }
        }
        return false;
    }

    public static String determineWinner(String userChoice, String computerChoice)
    {
        if (userChoice.equals(computerChoice))
         {
            return "It's a tie!";
        }
         else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) 
                   {
                         return "You win!";
                           }
                            else 
                            {
                                 return "Computer wins!";
                            }
    }
}
