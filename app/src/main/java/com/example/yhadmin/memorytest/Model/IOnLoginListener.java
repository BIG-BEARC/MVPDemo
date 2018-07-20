package com.example.yhadmin.memorytest.Model;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest.Model
 *  @文件名:   IOnLoginListener
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/20 14:26
 *  @描述：    TODO
 */

import com.example.yhadmin.memorytest.bean.User;

public interface IOnLoginListener {
    //登录成功，保存信息
    void loginSuccess(User user);

    void loginFail();
}
