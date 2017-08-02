package com.xym.spring.dao;

import com.xym.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/7/28.
 */

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findUserByUserName(final String username) {
        String sqlStr = "select user_id,user_name,credits from t_user_t where user_name=?";

        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{username}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(username);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user) {
        String sqlStr = "update t_user_t set last_visit=?,last_ip=?,credits=? where user_id=?";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
    }

    public int getMatchCount(String username, String password) {
        String sqlStr = "select count(*) from t_user_t where user_name=? and password=?";
        Integer count = jdbcTemplate.queryForObject(sqlStr, new Object[]{username, password}, Integer.class);
        return count;
    }
}
