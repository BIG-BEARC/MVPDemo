package com.example.yhadmin.memorytest.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yhadmin.memorytest.Presenter.WeatherPresenter;
import com.example.yhadmin.memorytest.R;

public class MainActivity
        extends AppCompatActivity
        implements IWetherView
{

    private WeatherPresenter mWeatherPresenter;
    private Button           mOkBtn;
    private ProgressDialog   mDialog;
    private TextView         mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWeatherPresenter = new WeatherPresenter(this);
        mTv = findViewById(R.id.weather_info);
        Button moreBtn = findViewById(R.id.more);
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("正在加载中,请稍后...");
        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub);
                if (viewStub != null) {
                    View     inflatedView = viewStub.inflate();
                    EditText editExtra1   = (EditText) inflatedView.findViewById(R.id.edit_extra1);
                    EditText editExtra2   = (EditText) inflatedView.findViewById(R.id.edit_extra2);
                    EditText editExtra3   = (EditText) inflatedView.findViewById(R.id.edit_extra3);
                }

            }
        });
        mOkBtn = findViewById(R.id.ok);
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWeatherPresenter.getNetworkInfo();
            }
        });
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null) {
                    mDialog.show();
                }
            }
        });

    }

    @Override
    public void dissmissWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });

    }

    @Override
    public void onInfoUpdate(final String info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTv != null && mDialog.isShowing()) {
                    mTv.setText(info);
                }
            }
        });

    }
}
