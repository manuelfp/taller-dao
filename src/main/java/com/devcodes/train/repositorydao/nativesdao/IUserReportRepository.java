package com.devcodes.train.repositorydao.nativesdao;

import com.devcodes.train.repositorydao.entities.Role;
import com.devcodes.train.repositorydao.models.UserReports;

import java.util.List;

public interface IUserReportRepository {
    List<UserReports> doUserReports();
    void insertRole(Role role);
}
