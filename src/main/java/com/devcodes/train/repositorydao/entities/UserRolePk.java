package com.devcodes.train.repositorydao.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserRolePk implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional=false)
    @NotNull
    @Column(name="id_user")
    private Integer user;

    @Basic(optional=false)
    @NotNull
    @Column(name="id_role")
    private Integer role;

    public UserRolePk(){ }

    public UserRolePk(@NotNull Integer user, @NotNull Integer role) {
        this.user = user;
        this.role = role;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
