package com.xym.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * desc
 *
 * @author xym
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser() {
        Object[] params = new Object[]{"xym", 66, "123456", new Date(), "127.0.0.1"};
        int update = jdbcTemplate.update("insert into t_user_t(user_name,credits,password,last_visit,last_ip)values(?,?,?,?,?)", params);

        System.out.println(update);
    }

    @Override
    public void updateUser() {
        int update = jdbcTemplate.update("update t_user_t set password=? where user_name=?", new Object[]{"555555", "xym"});
        System.out.println(update);
    }

    @Override
    public String getName() {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select * from t_user_t where user_name=?", new Object[]{"xym"});
        String user_name = sqlRowSet.getString("user_name");
        return user_name;
    }

    @Override
    public Integer getAge() {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select * from t_user_t where user_name=?", new Object[]{"xym"});
        int id = sqlRowSet.getInt("id");
        return id;
    }
}