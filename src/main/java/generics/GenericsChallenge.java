package main.java.generics;

import main.java.generics.dto.FootballPlayer;
import main.java.generics.dto.League;
import main.java.generics.dto.Team;

public class GenericsChallenge {

  /**
   * ArrayList<Teams> teams; Collection.sort(teams); Create a generic class to implement a league
   * table for sport. The class should allow teams to be added to the list, and store a list of teams
   * that belong to the league
   *
   * <p>Your class should have a method to print out the teams in order, with the teams at the top
   * of the league printed first.
   *
   * <p>only teams with the same type should be added to any particular instance of the league class
   * - program should fail to compile if attempt is made to add an incomplete team.
   */
  public static void main(String[] args) {

    Team<FootballPlayer> manchesterUntied = new Team<>("Manchester United");
    Team<FootballPlayer> chelsea = new Team<>("Chelsea");
    Team<FootballPlayer> arsenal = new Team<>("Arsenal");
    Team<FootballPlayer> liverpool = new Team<>("Liverpool");

    manchesterUntied.matchResult(chelsea, 2, 5);
    chelsea.matchResult(arsenal, 3, 4);
    arsenal.matchResult(liverpool, 6, 2);
    liverpool.matchResult(arsenal, 1, 3);

    League<Team<FootballPlayer>> footballLeague = new League<>("BPL");
    footballLeague.addTeam(manchesterUntied);
    footballLeague.addTeam(chelsea);
    footballLeague.addTeam(arsenal);
    footballLeague.addTeam(liverpool);

    footballLeague.printLeagueTable();
  }
}
