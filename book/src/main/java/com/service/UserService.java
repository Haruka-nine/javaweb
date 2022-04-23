package com.service;

import com.pojo.User;

public interface UserService {

    /**
     * 注册用户
     *
     * @param user
     */
    public User registUser(User user);

    /**
     * 登陆
     *
     * @param user
     * @return 返回null代表登陆失败
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     *
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
