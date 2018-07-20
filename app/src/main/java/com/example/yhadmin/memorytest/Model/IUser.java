package com.example.yhadmin.memorytest.Model;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest.Model
 *  @文件名:   IUser
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/20 11:51
 *  @描述：    TODO
 */

import com.example.yhadmin.memorytest.bean.User;

public interface IUser {
    void setUserInfo(String userName,String passWorld);
    User getUserInfo();
}
