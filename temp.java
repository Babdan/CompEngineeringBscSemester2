public class BasketballGame {

// Attributes
private String firstTeamName;
private String secondTeamName;
private int firstTeamScore;
private int secondTeamScore;
private String status;

/**
* @param firstTeamName
* @param secondTeamName
*/
public BasketballGame(String firstTeamName, String secondTeamName) {
this.firstTeamName = firstTeamName;
this.secondTeamName = secondTeamName;
this.firstTeamScore = 0;
this.secondTeamScore = 0;
this.status = "In Progress";
}

/**
* Records 1 point for the teamName Postcondition: the particular team's
* score is updated with a point 1
*
* @param teamName
*/
public void recordOnePoint(String teamName) {
if (this.firstTeamName.equalsIgnoreCase(teamName))
this.firstTeamScore += 1;
else if (this.secondTeamName.equalsIgnoreCase(teamName))
this.secondTeamScore += 1;
}

/**
* Records 2 point for the teamName Postcondition: the particular team's
* score is updated with a point 2
*
* @param teamName
*/
public void recordTwoPoint(String teamName) {
if (this.firstTeamName.equalsIgnoreCase(teamName))
this.firstTeamScore += 2;
else if (this.secondTeamName.equalsIgnoreCase(teamName))
this.secondTeamScore += 2;
}

/**
* Records 3 point for the teamName Postcondition: the particular team's
* score is updated with a point 3
*
* @param teamName
*/
public void recordThreePoint(String teamName) {
if (this.firstTeamName.equalsIgnoreCase(teamName))
this.firstTeamScore += 3;
else if (this.secondTeamName.equalsIgnoreCase(teamName))
this.secondTeamScore += 3;
}

/**
* Adds either 1 or 2 or 3 points to a team
*
* @param teamName
*/
public void addScore(String teamName, int score) {
switch (score) {
case 1:
recordOnePoint(teamName);
break;
case 2:
recordTwoPoint(teamName);
break;
case 3:
recordThreePoint(teamName);
break;
}
}

/**
* @return the status
*/
public String getStatus() {
return status;
}

/**
* @param status
* the status to set
*/
public void setStatus(String status) {
this.status = status;
}

/**
* @return the firstTeamName
*/
public String getFirstTeamName() {
return firstTeamName;
}

/**
* @return the secondTeamName
*/
public String getSecondTeamName() {
return secondTeamName;
}

/**
* @return the firstTeamScore
*/
public int getFirstTeamScore() {
return firstTeamScore;
}

/**
* @return the secondTeamScore
*/
public int getSecondTeamScore() {
return secondTeamScore;
}
/**
* @return the firstTeamScore
*/
public int getFirstTeamScore() {
return firstTeamScore;
}

/**
* @return the secondTeamScore
*/
public int getSecondTeamScore() {
return secondTeamScore;
}

/**
* Returns the name of the winning team
*
* @return
*/
public String getWinningTeam() {
if (this.firstTeamScore > secondTeamScore)
return firstTeamName;
else if (this.firstTeamScore < secondTeamScore)
return secondTeamName;
return null;
}

/* (non-Javadoc)
* @see java.lang.Object#toString()
*/
@Override
public String toString() {
return getFirstTeamName() + " " + getFirstTeamScore() + ", " +
getSecondTeamName() + " " + getSecondTeamScore() + "; " +
((getWinningTeam() != null) ? getWinningTeam() + " are winning." : "");
}
}

import java.util.Scanner;

public class BasketballGameDriver {

public static void main(String args[]) {
  
//Scanner to get user input
Scanner sc = new Scanner(System.in);
  
//Get the team names
System.out.print("Enter the name of team A: ");
String firstTeamName = sc.nextLine().trim();
  
System.out.print("Enter the name of team B: ");
String secondTeamName = sc.nextLine().trim();

//Create basketball game
BasketballGame game = new BasketballGame(firstTeamName, secondTeamName);
  
//Start game
System.out.println("Game is about to start. Please enter 'Q' anytime to stop the game.");
System.out.println("Team A: " + game.getFirstTeamName() + "\tTeam B: " + game.getSecondTeamName());
char ans = ' ';
  
while(true) {
System.out.print("Enter a score: ");
String score = sc.nextLine();
String[] teamDtls = score.split(" ");
  
//Check if 'Q' is entered
ans = teamDtls[0].charAt(0);
if(Character.toUpperCase(ans) == 'Q') {
String winningTeam = game.getWinningTeam();
if(winningTeam != null)
System.out.println(winningTeam + " won.");
else
System.out.println("No team won");

//Close sacnner
sc.close();
  
System.exit(0);
}
  
if(teamDtls[0].toUpperCase().equalsIgnoreCase("A")){
game.addScore(game.getFirstTeamName(), Integer.parseInt(teamDtls[1]));
} else if(teamDtls[0].toUpperCase().equalsIgnoreCase("B")){
game.addScore(game.getSecondTeamName(), Integer.parseInt(teamDtls[1]));
}
System.out.println(game);
}
}
}

SAMPLE OUTPUT:
