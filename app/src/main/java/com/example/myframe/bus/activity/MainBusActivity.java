package com.example.myframe.bus.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myframe.R;
import com.example.myframe.bus.fragment.BusChangeFragment;
import com.example.myframe.bus.fragment.LineFoundFragmenr;
import com.example.myframe.bus.fragment.NoStopFragment;
import com.example.myframe.bus.fragment.StationFoundFragment;
import com.example.myframe.bus.fragment.StorpUpFragment;
import com.example.myframe.http.base.BaseActivity;
import com.example.myframe.http.views.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainBusActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.rb_line_fond)
    RadioButton rbLineFond;
    @BindView(R.id.rb_buchange)
    RadioButton rbBuchange;
    @BindView(R.id.rb_station_fond)
    RadioButton rbStationFond;
    @BindView(R.id.rb_no_stop)
    RadioButton rbNoStop;
    @BindView(R.id.rb_store_up)
    RadioButton rbStoreUp;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    private LineFoundFragmenr lineFoundFragmenr;
    private BusChangeFragment busChangeFragment;
    private StationFoundFragment stationFoundFragment;
    private NoStopFragment noStopFragment;
    private StorpUpFragment storpUpFragment;

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //默认选中第一个
        RadioButton btn = (RadioButton) radioGroup.getChildAt(0);
        btn.setChecked(true);
        initFragment();
        radioGroup.setOnCheckedChangeListener(MainBusActivity.this);
    }
    /**
     * 初始化第一个页面
     */
    private void initFragment() {
        //获取管理器
        manager = getSupportFragmentManager();
        //通过管理器获取一个事件
        FragmentTransaction transaction = manager.beginTransaction();
        //添加第一个fragment到帧布局中
        lineFoundFragmenr = new LineFoundFragmenr();
        transaction.add(R.id.frame_layout, lineFoundFragmenr);
        transaction.commit();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main_bus;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            //线路查询
            case R.id.rb_line_fond:
                FragmentTransaction ft1 = manager.beginTransaction();
                hideAll(ft1);
                if (lineFoundFragmenr ==null){
                    lineFoundFragmenr = new LineFoundFragmenr();
                    ft1.add(R.id.frame_layout, lineFoundFragmenr);
                }else {
                    ft1.show(lineFoundFragmenr);
                }
                ft1.commit();
                break;
            //公交换乘
            case R.id.rb_buchange://联系人
                FragmentTransaction ft2 = manager.beginTransaction();
                hideAll(ft2);
                if (busChangeFragment ==null){
                    busChangeFragment = new BusChangeFragment();
                    ft2.add(R.id.frame_layout, busChangeFragment);
                }else {
                    ft2.show(busChangeFragment);
                }
                ft2.commit();
                break;
            //站点查询
            case R.id.rb_station_fond: //发现
                FragmentTransaction ft3 = manager.beginTransaction();
                hideAll(ft3);
                if (stationFoundFragment ==null){
                    stationFoundFragment = new StationFoundFragment();
                    ft3.add(R.id.frame_layout, stationFoundFragment);
                }else {
                    ft3.show(stationFoundFragment);
                }
                ft3.commit();
                break;
            //直达查询
            case R.id.rb_no_stop: //发现
                FragmentTransaction ft4 = manager.beginTransaction();
                hideAll(ft4);
                if (noStopFragment ==null){
                    noStopFragment = new NoStopFragment();
                    ft4.add(R.id.frame_layout, noStopFragment);
                }else {
                    ft4.show(noStopFragment);
                }
                ft4.commit();
                break;
            //收藏夹
            case R.id.rb_store_up: //发现
                FragmentTransaction ft5 = manager.beginTransaction();
                hideAll(ft5);
                if (storpUpFragment ==null){
                    storpUpFragment = new StorpUpFragment();
                    ft5.add(R.id.frame_layout, storpUpFragment);
                }else {
                    ft5.show(storpUpFragment);
                }
                ft5.commit();
                break;
        }
    }

    /**
     * 隐藏所有fragment
     * @param ft
     */
    private void hideAll(FragmentTransaction ft){
        if (ft==null){
            return;
        }
        if (lineFoundFragmenr !=null){
            ft.hide(lineFoundFragmenr);
        }
        if (busChangeFragment !=null){
            ft.hide(busChangeFragment);
        }
        if (stationFoundFragment !=null){
            ft.hide(stationFoundFragment);
        }
        if (noStopFragment !=null){
            ft.hide(noStopFragment);
        }
        if (storpUpFragment !=null){
            ft.hide(storpUpFragment);
        }
    }
}
