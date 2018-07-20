package com.example.yhadmin.memorytest.View;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest.View
 *  @文件名:   ILoginView
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/20 11:50
 *  @描述：    TODO
 */

import com.example.yhadmin.memorytest.bean.User;

public interface ILoginView {

    String getUserName();
    String getPassWorld();

    void waitingDialog();
    void dissmissWaitingDialog();

    void toMainActivity(User user);
    void showFailedError(int errorCode);

    void clearUserName();
    void clearPassword();
}
