package com.example.yhadmin.memorytest.Presenter;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest.Presenter
 *  @文件名:   LoginPresenter
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/20 14:34
 *  @描述：    TODO
 */

import android.os.Handler;

import com.example.yhadmin.memorytest.Constans;
import com.example.yhadmin.memorytest.Model.IOnLoginListener;
import com.example.yhadmin.memorytest.Model.UserBizImpl;
import com.example.yhadmin.memorytest.View.ILoginView;
import com.example.yhadmin.memorytest.bean.User;


public class LoginPresenter {
    UserBizImpl mUserBiz;
    ILoginView  mILoginView;
    Handler mHandler = new Handler();

    public LoginPresenter(ILoginView ILoginView) {
        this.mILoginView = ILoginView;
        mUserBiz = new UserBizImpl();
    }

    public void login() {
        String userName  = mILoginView.getUserName();
        String passWorld = mILoginView.getPassWorld();
        if (userName.isEmpty()) {
            mILoginView.showFailedError(Constans.USERNAME_ERROR);
            return;
        }
        if (passWorld.isEmpty()){
            mILoginView.showFailedError(Constans.PASSWORLD_ERROR);
            return;
        }
        mILoginView.waitingDialog();

        mUserBiz.login(userName, passWorld, new IOnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mILoginView.toMainActivity(user);
                        mILoginView.dissmissWaitingDialog();
                    }
                });

            }

            @Override
            public void loginFail() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mILoginView.dissmissWaitingDialog();
                        mILoginView.showFailedError(Constans.LOGIN_ERROR);
                    }
                });

            }
        });

    }

    public void clear() {
        mILoginView.clearUserName();
        mILoginView.clearPassword();
    }
}
