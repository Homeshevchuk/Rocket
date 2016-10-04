package com.example.Entities;

import com.example.JsonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 24.09.2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue

    private Long id;
    @JsonView(JsonViews.UserSummary.class)
    private String name;
    private String password;
    @JsonView(JsonViews.UserSummary.class)
    @ManyToMany(mappedBy = "users")
    private List<Team> teams = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(Team team) {
        this.teams = teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }
}
