package com.example.yhadmin.memorytest.Model;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest.Model
 *  @文件名:   IUserBiz
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/20 14:29
 *  @描述：    TODO
 */

public interface IUserBiz {
    void login(String userName,String passWorld,IOnLoginListener loginListener);
}
