package com.example.myframe.welcome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.myframe.R;
import com.example.myframe.http.views.StatusBarUtils;
import com.example.myframe.welcome.azlistview.PinyinUtils;
import com.example.myframe.welcome.bean.CityList;
import com.example.myframe.welcome.bean.LineList;
import com.example.myframe.welcome.bean.SaveLinelist;
import com.example.myframe.welcome.bean.StationList;
import com.example.myframe.welcome.module.WelcomeContract;
import com.example.myframe.welcome.presenter.WelcomePresenter;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity implements WelcomeContract.View {
    private WelcomePresenter presenter;
    Intent intent;
    //判断是都有城市列表缓存
//    List<CityList> dataList = DataSupport.findAll(CityList.class);
    List<SaveLinelist> lineList = DataSupport.findAll(SaveLinelist.class);
    List<StationList> stationList = DataSupport.findAll(StationList.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new StatusBarUtils().setWindowStatusBarColor(WelcomeActivity.this, R.color.white);

        if (lineList.size() != 0 && stationList.size() != 0) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        } else {
            presenter = new WelcomePresenter(this, this);
//            if (dataList.size()==0){
//                presenter.getCitysList();
//            }
            if (lineList.size() == 0) {
                presenter.getLineList();
            }
            if (stationList.size() == 0) {
                presenter.getStationList();
            }
        }
    }



    //获取城市列表
    @Override
    public void setCitysList(List<CityList> bean) {
        //创建城市数据库
        Connector.getDatabase();
        for (int i = 0; i < bean.size(); i++) {
            CityList bena = new CityList();
            bena.setCityName(bean.get(i).getCityName());
            bena.setCityCode(bean.get(i).getCityCode());
            bena.setIP(bean.get(i).getIP());
            bena.setBS_Port(bean.get(i).getBS_Port());
            bena.setSocket_Port(bean.get(i).getSocket_Port());
            bena.setCenter_X(bean.get(i).getCenter_X());
            bena.setCenter_Y(bean.get(i).getCenter_Y());
            //汉字转换成拼音
            String pinyin = PinyinUtils.getPingYin(bean.get(i).getCityName());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                bena.setLetters(sortString);
            } else {
                bena.setLetters("#");
            }
            bena.save();
        }
        intent = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setLineList(LineList bean) {
        //创建城市数据库
        Connector.getDatabase();
        for (int i = 0; i < bean.getLineList().size(); i++) {
            SaveLinelist bena = new SaveLinelist();
            bena.setLineCode(bean.getLineList().get(i).getLineCode());
            bena.setLineName(bean.getLineList().get(i).getLineName());
            bena.save();
        }
    }

    @Override
    public void setStationList(StationList bean) {
        //创建城市数据库
        Connector.getDatabase();
        for (int i = 0; i < bean.getList().size(); i++) {
            StationList bena = new StationList();
            List<StationList.ListBean> beanList = new ArrayList<>();
            StationList.ListBean benaSmall = new StationList.ListBean();
            benaSmall.setXL(bean.getList().get(i).getXL());
            benaSmall.setXLMC(bean.getList().get(i).getXLMC());
            benaSmall.setZD(bean.getList().get(i).getZD());
            benaSmall.setZDNAME(bean.getList().get(i).getZDNAME());
            benaSmall.setSXX(bean.getList().get(i).getSXX());
            benaSmall.setJD(bean.getList().get(i).getJD());
            benaSmall.setWD(bean.getList().get(i).getWD());
            beanList.add(benaSmall);
            bena.setList(beanList);
            bena.save();
        }
        intent = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    //获取错误信息
    @Override
    public void setCitysListMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
