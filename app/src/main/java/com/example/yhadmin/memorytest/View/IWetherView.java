package com.example.yhadmin.memorytest.View;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest.View
 *  @文件名:   IWetherView
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/20 10:57
 *  @描述：    TODO
 */

public interface IWetherView {
    void showWaitingDialog();
    void dissmissWaitingDialog();
    void onInfoUpdate(String info);
}
