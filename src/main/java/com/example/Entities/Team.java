package com.example.Entities;

import com.example.JsonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 24.09.2016.
 */
@Entity
public class Team {
    @Id
    @GeneratedValue
    @JsonView(JsonViews.UserSummary.class)
    private Long id;
    @OneToOne
    private User lead;
    @ManyToMany
    @JoinTable(name = "team_user", joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> users = new ArrayList<>();

    public User getLead() {
        return lead;
    }

    public void setLead(User lead) {
        this.lead = lead;
        users.add(lead);
    }

    public void addUser(User user){
        if(user!=null){
            user.addTeam(this);
            users.add(user);
        }

    }
    public void deleteUser(User user){
        if(user!=null){
            user.setTeams(null);
            users.remove(user);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
