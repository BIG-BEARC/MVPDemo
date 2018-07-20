package com.example.yhadmin.memorytest.View;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yhadmin.memorytest.Constans;
import com.example.yhadmin.memorytest.Presenter.LoginPresenter;
import com.example.yhadmin.memorytest.R;
import com.example.yhadmin.memorytest.bean.User;

public class LoginActivity
        extends AppCompatActivity
        implements ILoginView
{

    private EditText       mUserNameEt;
    private EditText       mPassWorldEt;
    private Button         mLoginBtn;
    private Button         mClearBtn;
    private ProgressDialog mProgressDialog;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("正在登录中,请稍后...");
        mUserNameEt = findViewById(R.id.user_name_et);
        mPassWorldEt = findViewById(R.id.passworld_et);
        mLoginBtn = findViewById(R.id.login_btn);
        mClearBtn = findViewById(R.id.clear_btn);

        mLoginPresenter = new LoginPresenter(this);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.login();
            }
        });

        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {

        return mUserNameEt.getText()
                          .toString()
                          .trim();
    }

    @Override
    public String getPassWorld() {
        return mPassWorldEt.getText()
                           .toString()
                           .trim();
    }

    @Override
    public void waitingDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.show();
        }
    }

    @Override
    public void dissmissWaitingDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,
                       "用户名:" + user.getUserName() + "密码:" + user.getPassWorld(),
                       Toast.LENGTH_SHORT)
             .show();
    }

    @Override
    public void showFailedError(int errorCode) {
        switch (errorCode) {
            case Constans.USERNAME_ERROR:
            Toast.makeText(this, "用户名不能为空!", Toast.LENGTH_SHORT)
                 .show();
            break;
            case Constans.PASSWORLD_ERROR:
            Toast.makeText(this, "密码不能为空!", Toast.LENGTH_SHORT)
                 .show();
            break;
            case Constans.LOGIN_ERROR:
                Toast.makeText(this, "登录失败!", Toast.LENGTH_SHORT)
                     .show();
                break;
            default:
                break;
        }

    }

    @Override
    public void clearUserName() {
        mUserNameEt.setText("");
    }

    @Override
    public void clearPassword() {
        mPassWorldEt.setText("");
    }
}
