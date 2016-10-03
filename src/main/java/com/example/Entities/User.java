package com.example.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String name;
    private String password;
    @ManyToMany
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

    public List<Team> getTeam() {
        return teams;
    }

    public void setTeam(Team team) {
        this.teams = teams;
    }
}
