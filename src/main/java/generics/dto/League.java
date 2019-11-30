package main.java.generics.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T extends Team> {
  private String name;
  private List<T> teams = new ArrayList<>();

  public League(String name) {
    this.name = name;
  }

  public boolean addTeam(T team) {
    if (teams.contains(team)) {
      return false;
    } else {
      teams.add(team);
      return true;
    }
  }

  public void printLeagueTable() {
    Collections.sort(teams);
    teams.forEach(team -> System.out.println(team.getName() + " : " + team.ranking()));
  }
}
