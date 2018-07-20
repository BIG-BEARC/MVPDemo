package com.example.yhadmin.memorytest.Model;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest.Model
 *  @文件名:   IWetherImpl
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/20 10:59
 *  @描述：    TODO
 */

public class IWetherImpl
        implements IWetherModel
{
    String info;

    @Override
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String getInfo() {
        return info;
    }
}
