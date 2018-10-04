package com.devcodes.train.repositorydao.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotNull
    @Column(name="role")
    private String role;

    @NotNull
    @Column(name="description")
    private String description;

    public Role(){}

    public Role(Integer id){
        this.id = id;
    }

    public Role(@NotNull String role, @NotNull String description) {
        this.role = role;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
