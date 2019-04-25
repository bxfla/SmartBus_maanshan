package com.example.myframe.main.activity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.myframe.R;
import com.example.myframe.bus.activity.MainBusActivity;
import com.example.myframe.http.base.BaseActivity;
import com.example.myframe.http.utils.BaseRecyclerAdapter;
import com.example.myframe.http.utils.BaseViewHolder;
import com.example.myframe.http.utils.GlideImageLoader;
import com.example.myframe.http.views.Header;
import com.example.myframe.main.module.BannerContract;
import com.example.myframe.main.presenter.BannerPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BannerContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    BannerPresenter bannerPresenter;
    private ApplicationInfo mAppInfo;
    private BaseRecyclerAdapter mAdapter;
    Intent intent;
    List<com.example.myframe.main.bean.Banner.InterfaceBean> interfaceBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mAppInfo = getApplicationInfo();
        bannerPresenter = new BannerPresenter(this, this);
        bannerPresenter.getBanner();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void setBanner(com.example.myframe.main.bean.Banner bannerView) {
        com.example.myframe.main.bean.Banner.InterfaceBean bean =
                new com.example.myframe.main.bean.Banner.InterfaceBean();
        bean.setTitle("公交车");
        bean.setIconType("1");
        int resID = getResources().getIdentifier("ic_bus", "drawable", mAppInfo.packageName);
        bean.setIcon(resID);
        bean.setWebURL("");
        interfaceBeanList.add(bean);
        if (bannerView.getInterface() != null && bannerView.getInterface().size() != 0) {
            for (int i = 0; i < bannerView.getInterface().size(); i++) {
                interfaceBeanList.add(bannerView.getInterface().get(i));
            }
        }
        List<String> bannerList = new ArrayList<>();
        for (int k = 0; k < bannerView.getAdvertisement().size(); k++) {
            if (bannerView.getAdvertisement().get(k).getPage().equals("mainPage")) {
                for (int i = 0; i < bannerView.getAdvertisement().get(k).getDisplay().size(); i++) {
                    bannerList.add(bannerView.getAdvertisement().get(k).getDisplay().get(i).getContent());
                }
            }
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(bannerList);
        //设置轮播时间
        banner.setDelayTime(6000);
//            //标题
//            banner.setBannerTitles(titleList);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        mAdapter = new BaseRecyclerAdapter<com.example.myframe.main.bean.Banner.InterfaceBean>(this, R.layout.main_recycleritem, interfaceBeanList) {
            @Override
            public void convert(BaseViewHolder holder, final com.example.myframe.main.bean.Banner.InterfaceBean s) {
                holder.setText(R.id.textView, s.getTitle());
                holder.setImageResource(R.id.imageView, s.getIcon());
                holder.setOnClickListener(R.id.linearLayout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (s.getTitle().equals("公交车")){
                            intent = new Intent(MainActivity.this, MainBusActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        };

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setBannerMessage(String s) {
        Toast.makeText(this, "获取banner图失败", Toast.LENGTH_SHORT).show();
    }
}

