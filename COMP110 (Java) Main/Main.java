// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (March 2nd, 2022)

// Importing the Scanner class
import java.util.Scanner;

// Write a program that uses the class BasketballGame to keep track of the score of a basketball game.
public class Main {
    public static void main(String[] args) {
        //Scanner to get user input
        Scanner input = new Scanner(System.in);
        //Prompting user to enter the team names
        System.out.print("Please enter the name of the first team: ");
        String firstTeamName = input.nextLine().trim();
        System.out.print("Please enter the name of the second team: ");
        String secondTeamName = input.nextLine().trim();
        //Initializing the game
        BasketballGame game = new BasketballGame(firstTeamName, secondTeamName);
        //Game being started
        System.out.println("Game is about to start. Please enter 'Q' anytime to stop the game.");
        System.out.println("Team A: " + game.getFirstTeamName() + "\tTeam B: " + game.getSecondTeamName());
        char ans;
        while(true) {
            System.out.print("Enter a score: ");
            String score = input.nextLine();
            String[] teamDtls = score.split(" ");
            //Checking if the user wants to stop the game
            ans = teamDtls[0].charAt(0);
            if(Character.toUpperCase(ans) == 'Q') {
                String winningTeam = game.getWinningTeam();
                if(winningTeam != null)
                    System.out.println(winningTeam + " won.");
                else
                    System.out.println("No team won");
                //Scanner is closed
                input.close();
                System.exit(0);
            }
            if(teamDtls[0].equalsIgnoreCase("A")){
                game.addScore(game.getFirstTeamName(), Integer.parseInt(teamDtls[1]));
            } else if(teamDtls[0].equalsIgnoreCase("B")){
                game.addScore(game.getSecondTeamName(), Integer.parseInt(teamDtls[1]));
            }
            System.out.println(game);
        }
    }
}
