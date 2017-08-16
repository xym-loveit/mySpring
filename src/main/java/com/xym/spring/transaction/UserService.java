package com.xym.spring.transaction;

import java.io.IOException;

/**
 * Created by xym on 2017/8/16.
 */
public interface UserService {

    public void addUser() throws IOException;

    public void updateUser();

    public String getName();

    public Integer getAge();
}
