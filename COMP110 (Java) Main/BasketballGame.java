// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (March 2nd, 2022)

// A class BasketballGame that represents the state of a basketball
public class BasketballGame {
    // Attributes
    private String firstTeamName;
    private String secondTeamName;
    private int firstTeamScore;
    private int secondTeamScore;
    private String status;
    // Method that sets the names of the teams and initial scores
    public BasketballGame(String firstTeamName, String secondTeamName) {
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
        this.firstTeamScore = 0;
        this.secondTeamScore = 0;
        this.status = "Ongoing";
    }
    // Method that records 1 point scored for the given teamName
    public void recordOnePoint(String teamName) {
        if (this.firstTeamName.equalsIgnoreCase(teamName))
            this.firstTeamScore += 1;
        else if (this.secondTeamName.equalsIgnoreCase(teamName))
            this.secondTeamScore += 1;
    }
    // Method that records 2 points scored for the given teamName
    public void recordTwoPoint(String teamName) {
        if (this.firstTeamName.equalsIgnoreCase(teamName))
            this.firstTeamScore += 2;
        else if (this.secondTeamName.equalsIgnoreCase(teamName))
            this.secondTeamScore += 2;
    }
    // Method that records 3 points scored for the given teamName
    public void recordThreePoint(String teamName) {
        if (this.firstTeamName.equalsIgnoreCase(teamName))
            this.firstTeamScore += 3;
        else if (this.secondTeamName.equalsIgnoreCase(teamName))
            this.secondTeamScore += 3;
    }
    // Method that records 1,2 or 3 points scored for the given teamName
    public void addScore(String teamName, int score) {
        switch (score) {
            case 1 -> recordOnePoint(teamName);
            case 2 -> recordTwoPoint(teamName);
            case 3 -> recordThreePoint(teamName);
        }
    }
    // Method that alters the status of the game
    public void setStatus(String status) {
        this.status = status;
    }
    // Method that returns the status of the game
    public String getStatus() {
        return status;
    }
    // Method that returns the name of the team that is currently winning
    public String getWinningTeam() {
        if (this.firstTeamScore > secondTeamScore)
            return firstTeamName;
        else if (this.firstTeamScore < secondTeamScore)
            return secondTeamName;
        return null;
    }
    // Returns the name of the first team
    public String getFirstTeamName() {
        return firstTeamName;
    }
    // Returns the name of the second team
    public String getSecondTeamName() {
        return secondTeamName;
    }
    // Returns the score of the first team
    public int getFirstTeamScore() {
        return firstTeamScore;
    }
    // Returns the score of the second team
    public int getSecondTeamScore() {
        return secondTeamScore;
    }
    // Returns the score of the game
    @Override
    public String toString() {
        return getFirstTeamName() + " " + getFirstTeamScore() + ", " +
                getSecondTeamName() + " " + getSecondTeamScore() + "; " +
                ((getWinningTeam() != null) ? getWinningTeam() + " are winning." : "");
    }
}