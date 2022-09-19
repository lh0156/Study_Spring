package player.service;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Player {

    public Player() {

    }

    public Player(String name, String team) {
        this.id = (new Date()).getTime();
        this.name = name;
        this.team = team;
    }

    private long id;
    private String name;
    private String team;
}
