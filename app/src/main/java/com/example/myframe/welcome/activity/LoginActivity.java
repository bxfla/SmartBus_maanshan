package com.example.myframe.welcome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myframe.R;
import com.example.myframe.SharedPreferencesHelper;
import com.example.myframe.http.base.BaseActivity;
import com.example.myframe.http.base.Constant;
import com.example.myframe.http.views.Header;
import com.example.myframe.main.activity.MainActivity;
import com.example.myframe.welcome.bean.CityList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.et_LoginName)
    EditText etLoginName;
    @BindView(R.id.et_LoginPassword)
    EditText etLoginPassword;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        intent = new Intent(this, CityActivity.class);
        startActivityForResult(intent, Constant.TAG_ONE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            CityList cityList = data.getStringArrayListExtra("city");
//            for (String s : list) {
//                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
//                File file = new File(s);
//                Toast.makeText(getActivity(), file.getName(), Toast.LENGTH_SHORT).show();
////                    file = file+s;
//            }
//        }
        if (requestCode == Constant.TAG_ONE && requestCode == Constant.TAG_ONE) {
            if (data != null) {
                CityList cityList = (CityList) data.getSerializableExtra("city");
                SharedPreferencesHelper spHelper = new SharedPreferencesHelper(this, "city");
                spHelper.saveData(this, "cityName", cityList.getCityName());
                spHelper.saveData(this, "cityCode", cityList.getCityCode());
                spHelper.saveData(this, "Ip", cityList.getIP());
                spHelper.saveData(this, "bsPort", cityList.getBS_Port());
                spHelper.saveData(this, "socketPort", cityList.getSocket_Port());
                spHelper.saveData(this, "Center_X", cityList.getCenter_X());
                spHelper.saveData(this, "Center_Y", cityList.getCenter_Y());
            }
        }
    }

    @OnClick({R.id.forget_password, R.id.btn_login, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_password:
                break;
            case R.id.btn_login:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_register:
                break;
        }
    }
}
