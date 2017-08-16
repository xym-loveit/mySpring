package com.xym.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * desc
 *
 * @author xym
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser() throws IOException {
        userDao.addUser();
        System.out.println("新增用户");
        //检查性异常
        throw new IOException("测试下检查性异常回滚");
    }

    @Override
    public void updateUser() {
        userDao.updateUser();
        System.out.println("修改用户");
        throw new IllegalArgumentException("运行期异常spring默认回滚，我们可以设置，令其提交不回滚");
    }

    @Override
    public String getName() {
        String name = userDao.getName();
        System.out.println("获取用户姓名：" + name);
        return name;
    }

    @Override
    public Integer getAge() {
        Integer age = userDao.getAge();
        System.out.println("获取用户年龄：" + age);
        return age;
    }
}