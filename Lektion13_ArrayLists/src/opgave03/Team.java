package opgave03;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public void addPlayer(Player ply) {
        players.add(ply);
    }

    public String getName() {
        return name;
    }
}
