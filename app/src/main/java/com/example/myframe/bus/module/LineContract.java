package com.example.myframe.bus.module;

import com.example.myframe.bus.bean.LineBean;
import com.example.myframe.http.base.BaseDView;
import com.example.myframe.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface LineContract {
    interface View extends BaseDView<presenter> {
        //设置查询线路
        void setLineBean(LineBean lineBean);
        void setLineBeanMessage(String message);
    }

    interface presenter extends BasePresenter {
        //线路回调
        void getLineBean(String code);
    }
}
