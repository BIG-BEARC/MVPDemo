package com.example.yhadmin.memorytest.Presenter;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest.Presenter
 *  @文件名:   WeatherPresenter
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/20 11:03
 *  @描述：    TODO
 */

import com.example.yhadmin.memorytest.Model.IWetherImpl;
import com.example.yhadmin.memorytest.Model.IWetherModel;
import com.example.yhadmin.memorytest.View.IWetherView;

public class WeatherPresenter {

    IWetherView  mIWetherView;
    IWetherModel mIWetherModel;

    public WeatherPresenter(IWetherView mView) {
        this.mIWetherView = mView;
        mIWetherModel = new IWetherImpl();
    }

    //供View层调用，用来请求天气数据
    public void requestWetherInfo() {
        getNetworkInfo();
    }

    private void showWaitingDialog() {
        if (mIWetherView != null) {
            mIWetherView.showWaitingDialog();
        }
    }

    private void dissmissWaitingDialog() {
        if (mIWetherView != null) {
            mIWetherView.dissmissWaitingDialog();
        }
    }

    private void updateWetherInfo(String info) {
        if (mIWetherView != null) {
            mIWetherView.onInfoUpdate(info);
        }
    }

    private void saveInfo(String info) {
        if (mIWetherModel != null) {
            mIWetherModel.setInfo(info);
        }
    }

    private String loadInfo() {
        if (mIWetherModel != null) {
            return mIWetherModel.getInfo();
        }
        return "";
    }

    public void getNetworkInfo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                showWaitingDialog();

                try {
                    Thread.sleep(1000);

                    String info = "21度，晴转多云";
                    saveInfo(info);
                    //从Model层获取数据，为了演示效果，实际开发中根据情况需要。
                    String localinfo = loadInfo();


                    updateWetherInfo(localinfo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    dissmissWaitingDialog();
                }
            }
        }).start();
    }
}
