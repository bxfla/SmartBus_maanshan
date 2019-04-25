package com.example.myframe.welcome.module;

import com.example.myframe.http.base.BaseDView;
import com.example.myframe.http.base.BasePresenter;
import com.example.myframe.welcome.bean.CityList;
import com.example.myframe.welcome.bean.LineList;
import com.example.myframe.welcome.bean.StationList;

import java.util.List;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface WelcomeContract {
    interface View extends BaseDView<presenter> {
        //获取城市列表
        void setCitysList(List<CityList> bean);
        //获取线路列表
        void setLineList(LineList bean);
        //获取车站列表
        void setStationList(StationList bean);

        void setCitysListMessage(String s);
    }

    interface presenter extends BasePresenter {
        //城市列表回调
        void getCitysList();

        void getLineList();
        void getStationList();
    }
}
