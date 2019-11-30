package main.java.generics.dto;

import java.util.ArrayList;
import java.util.List;

// we set an upper bound for type parameter so that
// we T is limited to only classes that extend player and no
// random value should be used.
// if you want to use multiple bounds , syntax is <T extends Player & Coach & Manager>
// where player is a class, coach and manager are interfaces
// first has to be class or java will raise an error
public class Team<T extends Player> implements Comparable<Team<T>> {

  private String name;
  int played = 0;
  int won = 0;
  int lost = 0;
  int tied = 0;
  private List<T> members = new ArrayList<>();

  public Team(String name) {
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public boolean addPlayer(T player) {
    if (members.contains(player)) {
      System.out.println(player.getName() + " is already in the team.");
      return false;
    } else {
      members.add(player);
      System.out.println(player.getName() + " picked for team" + this.name);
      return true;
    }
  }

  public int numPlayers() {
    return this.members.size();
  }

  public void matchResult(Team opponent, int ourScore, int oppScore) {
    if (ourScore > oppScore) {
      won++;
    } else if (oppScore == ourScore) {
      tied++;
    } else {
      lost++;
    }
    played++;
    if (opponent != null) {
      opponent.matchResult(null, oppScore, ourScore);
    }
  }

  public int ranking() {
    return (won * 2) + tied;
  }

  @Override
  public int compareTo(Team<T> team) {
    if (this.ranking() > team.ranking()) {
      return -1;
    } else if (this.ranking() < team.ranking()) {
      return 1;
    } else {
      return 0;
    }
  }
}
