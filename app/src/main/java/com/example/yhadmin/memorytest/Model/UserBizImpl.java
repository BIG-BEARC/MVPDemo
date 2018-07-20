package com.example.yhadmin.memorytest.Model;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest.Model
 *  @文件名:   UserBizImpl
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/20 14:30
 *  @描述：    Model 的具体业务逻辑处理类
 */

import com.example.yhadmin.memorytest.bean.User;

public class UserBizImpl
        implements IUserBiz
{
    @Override
    public void login(final String userName,
                      final String passWorld,
                      final IOnLoginListener loginListener)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if (userName.equals("cx") && passWorld.equals("123")) {

                        User user = new User();
                        user.setUserName(userName);
                        user.setPassWorld(passWorld);
                        loginListener.loginSuccess(user);
                    } else {
                        loginListener.loginFail();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
