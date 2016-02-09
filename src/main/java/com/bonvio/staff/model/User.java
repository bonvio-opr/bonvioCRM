package com.bonvio.staff.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by niko on 03.06.15.
 */
@Entity
@Table (name = "user")
public class User implements Serializable {

    public User(){

    }

    public User(String login, String password, boolean b, boolean b1, boolean b2, boolean b3, List<GrantedAuthority> authorities) {
        //
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Id
    @GeneratedValue
    private Integer id;
    private String login;
    private String password;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<UserRole>(0);


    @OneToMany (mappedBy = "developer")
    private List <Ticket> tickets = new ArrayList<Ticket>();


    //@JsonManagedReference
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Set<UserRole> getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
