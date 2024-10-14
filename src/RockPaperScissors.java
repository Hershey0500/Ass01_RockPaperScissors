import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            String playerAChoice = getPlayerChoice(scanner, "Player A");
            String playerBChoice = getPlayerChoice(scanner, "Player B");

            // Determine the result
            String result = determineWinner(playerAChoice, playerBChoice);
            System.out.println(result);

            // Ask if they want to play again
            System.out.print("Play again? (Yes/No): ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }
    }

    public static String getPlayerChoice(Scanner scanner, String player) {
        String choice;
        while (true) {
            System.out.print(player + ", enter your choice (R, P, S): ");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("R") || choice.equalsIgnoreCase("P") || choice.equalsIgnoreCase("S")) {
                break;
            } else {
                System.out.println("Invalid input! Please enter R, P, or S.");
            }
        }
        return choice;
    }

    public static String determineWinner(String playerAChoice, String playerBChoice) {
        if (playerAChoice.equalsIgnoreCase(playerBChoice)) {
            return "It's a Tie!";
        }
        switch (playerAChoice.toUpperCase()) {
            case "R":
                if (playerBChoice.equalsIgnoreCase("S")) {
                    return "Rock breaks Scissors! Player A wins!";
                } else {
                    return "Paper covers Rock! Player B wins!";
                }
            case "P":
                if (playerBChoice.equalsIgnoreCase("R")) {
                    return "Paper covers Rock! Player A wins!";
                } else {
                    return "Scissors cut Paper! Player B wins!";
                }
            case "S":
                if (playerBChoice.equalsIgnoreCase("P")) {
                    return "Scissors cut Paper! Player A wins!";
                } else {
                    return "Rock breaks Scissors! Player B wins!";
                }
        }
        return "Error determining the winner.";
    }
}
