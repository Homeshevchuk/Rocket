package com.example.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by PC on 24.09.2016.
 */
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private User lead;
    @ManyToMany
    private List<User> users = new ArrayList<>();

    public User getLead() {
        return lead;
    }

    public void setLead(User lead) {
        this.lead = lead;
        users.add(lead);
        lead.setTeam(this);
    }

    public void addUser(User user){
        if(user!=null){
            user.setTeam(this);
            users.add(user);
        }
    }
    public void deleteUser(User user){
        if(user!=null){
            user.setTeam(null);
            users.remove(user);
        }
    }
}
