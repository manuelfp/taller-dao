package com.devcodes.train.repositorydao.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class UserRole {

    @EmbeddedId
    protected UserRolePk userRolePK;

    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;


    @JoinColumn(name = "id_role", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date create;

    public UserRole() { }

    public UserRole(UserRolePk userRolePK, User user, Role role, Date created) {
        this.userRolePK = userRolePK;
        this.user = user;
        this.role = role;
        this.create = created;
    }

    public UserRole(UserRolePk userRolePK) {
        this.userRolePK = userRolePK;
    }

    public UserRolePk getUserRolePK() {
        return userRolePK;
    }

    public void setUserRolePK(UserRolePk userRolePK) {
        this.userRolePK = userRolePK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}
