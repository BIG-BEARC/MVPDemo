package com.example.yhadmin.memorytest;

/*
 *  @项目名：  MemoryTest 
 *  @包名：    com.example.yhadmin.memorytest
 *  @文件名:   TestManager
 *  @创建者:   YHAdmin
 *  @创建时间:  2018/7/16 16:02
 *  @描述：    TODO
 */

import java.util.ArrayList;
import java.util.List;

public class TestManager {
    private List<OnDataArrivedListener> mOnDataArrivedListeners = new ArrayList<OnDataArrivedListener>();

    private TestManager() {
    }

    private static class SingletonHolder {
        private static final TestManager INSTANCE = new TestManager();
    }

    public static TestManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public interface OnDataArrivedListener {
        void OnDataArrived(Object data);
    }

    public synchronized void regiesterListener(OnDataArrivedListener listener) {
        if (!mOnDataArrivedListeners.contains(listener)) {
            mOnDataArrivedListeners.add(listener);
        }

    }
}
