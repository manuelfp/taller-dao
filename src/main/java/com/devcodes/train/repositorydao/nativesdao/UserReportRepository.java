package com.devcodes.train.repositorydao.nativesdao;

import com.devcodes.train.repositorydao.entities.Role;
import com.devcodes.train.repositorydao.models.UserReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserReportRepository implements IUserReportRepository {

    private static final String REPORT_USER = "SELECT A.ID, A.USERNAME, CONCAT(CONCAT(A.FIRST_NAME, ' '), A.LAST_NAME) AS FULLNAME, C.ROLE AS ROLE FROM USER A INNER JOIN USER_ROLE B ON A.ID = B.ID_USER INNER JOIN ROLE C ON C.ID = B.ID_ROLE; ";
    private static final String INSERT_QUERY_ROLE = "INSERT INTO ROLE(ROLE, DESCRIPTION) VALUES(?, ?)";
    private DataSource dataSource;

    @Autowired
    public UserReportRepository (DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<UserReports> doUserReports(){
        try {
            Connection  connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(REPORT_USER);

            ResultSet rs = ps.executeQuery();
            List<UserReports> list = new ArrayList<>();

            while(rs.next()){
                UserReports userReports = new UserReports();
                userReports.setId(rs.getInt(1));
                userReports.setUsername(rs.getString(2));
                userReports.setFullname(rs.getString(3));
                userReports.setRoles(rs.getString(4));
                list.add(userReports);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public void insertRole(Role role){
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_ROLE);
            ps.setString(1, role.getRole());
            ps.setString(2, role.getDescription());
            ps.execute();
            System.out.println("INSERCION CORRECTA.");
        }catch (SQLException ex){
            System.out.println("ALGO SALIO MAL.");
        }

    }
}
