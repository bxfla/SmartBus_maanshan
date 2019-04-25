package com.example.myframe.welcome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myframe.R;
import com.example.myframe.http.base.BaseActivity;
import com.example.myframe.http.base.Constant;
import com.example.myframe.http.views.Header;
import com.example.myframe.welcome.adapter.CityAdapter;
import com.example.myframe.welcome.azlistview.EditTextWithDel;
import com.example.myframe.welcome.azlistview.PinyinComparatorP;
import com.example.myframe.welcome.azlistview.PinyinUtils;
import com.example.myframe.welcome.azlistview.SideBar;
import com.example.myframe.welcome.bean.CityList;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.et_search)
    EditTextWithDel etSearch;
    @BindView(R.id.lv_contact)
    ListView lvContact;
    @BindView(R.id.dialog)
    TextView dialog;
    @BindView(R.id.sidrbar)
    SideBar sidrbar;

    List<CityList> dataList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    CityAdapter cityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        dataList = DataSupport.findAll(CityList.class);
        //
        if (dataList.size() != 0) {
            initDatas();
            initEvents();
            setAdapter();
        }
    }
    private void initDatas() {
        sidrbar.setTextView(dialog);
    }

    private void initEvents() {
        //设置右侧触摸监听
        sidrbar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = cityAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    lvContact.setSelection(position + 1);
                }
            }
        });

        //ListView的点击事件
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (ListView.CHOICE_MODE_MULTIPLE == lvContact.getChoiceMode()) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_city_name);
                    if (!selectList.contains(textView.getText().toString())){
                        selectList.add(textView.getText().toString());
                    }else {
                        for (int i = 0;i<selectList.size();i++){
                            if (selectList.get(i).equals(textView.getText().toString())){
                                selectList.remove(i);
                            }
                        }
                    }
                }
            }
        });

        //根据输入框输入值的改变来过滤搜索
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<CityList> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = dataList;
        } else {
            mSortList.clear();
            for (CityList sortModel : dataList) {
                String name = sortModel.getCityName();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparatorP());
        cityAdapter.updateListView(mSortList);
    }

    private void setAdapter() {
        Collections.sort(dataList, new PinyinComparatorP());
        cityAdapter = new CityAdapter(this, dataList);
        lvContact.setAdapter(cityAdapter);
        cityAdapter.setOnClientMyTextView(new CityAdapter.CallBackPosition() {
            @Override
            public void myTextViewClient(CityList bean) {
                Intent intent = new Intent();
                intent.putExtra("city", bean);
                setResult(Constant.TAG_ONE, intent);
                finish(); //结束当前的activity的生命周期
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_city;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
