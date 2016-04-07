package edu.bsu.cs222.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    public List<Player> createTeam(int players) {
        List<Player> team = new ArrayList<Player>();
        for (int i = 1; i <= players; i++) {
            team.add(new Player());
        }
        return team;
    }

}
