package com.example.myframe.bus.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myframe.R;
import com.example.myframe.bus.bean.BusTimeListBean;
import com.example.myframe.bus.bean.LineBean;
import com.example.myframe.bus.bean.LineListBean;
import com.example.myframe.bus.bean.StationListBean;
import com.example.myframe.bus.module.LineContract;
import com.example.myframe.bus.presenter.LinePresenter;
import com.example.myframe.http.base.AlertDialogCallBack;
import com.example.myframe.http.base.AlertDialogUtil;
import com.example.myframe.http.utils.BaseRecyclerAdapter;
import com.example.myframe.http.utils.BaseViewHolder;
import com.example.myframe.welcome.azlistview.EditTextWithDel;
import com.example.myframe.welcome.bean.SaveLinelist;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/4/12.
 * 线路查询
 */

public class LineFoundFragmenr extends Fragment implements LineContract.View {
    View view;
    @BindView(R.id.edit_query)
    EditTextWithDel editQuery;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    String data = "";
    BaseRecyclerAdapter adapter;
    List<SaveLinelist> lineList = new ArrayList<>();
    List<String> upStationList = new ArrayList<>();
    List<String> downStationList = new ArrayList<>();
    LinePresenter linePresenter;
    String lineCode = "";
    String lineName = "";
    String upStation = "";
    String downStation = "";
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_linefound, container, false);
        unbinder = ButterKnife.bind(this, view);
        linePresenter = new LinePresenter(getActivity(), this);
        lineList = DataSupport.findAll(SaveLinelist.class);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        adapter = new BaseRecyclerAdapter<SaveLinelist>(getActivity(), R.layout.adapter_easy_item, lineList) {
            @Override
            public void convert(BaseViewHolder holder, final SaveLinelist lineListBean) {
                holder.setText(R.id.textView, lineListBean.getLineName());
                holder.setOnClickListener(R.id.textView, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击线路的线路号
                        lineCode = lineListBean.getLineCode();
                        lineName = lineListBean.getLineName();
                        List<StationListBean> stationListBean = new ArrayList<StationListBean>();
                        try {
                            //根据线路号查询站点
                            stationListBean = DataSupport.where("lineCode=?", lineCode).find(StationListBean.class);
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                        }
                        //判断查询站点数量为0重新获取  不为0显示
                        if (stationListBean.size() == 0) {
                            linePresenter.getLineBean(lineListBean.getLineCode());
                        } else {
                            for (int i = 0;i<stationListBean.size();i++){
                                if (stationListBean.get(i).getSxx().equals("0")){
                                    upStationList.add(stationListBean.get(i).getStationName());
                                }else if (stationListBean.get(i).getSxx().equals("1")){
                                    downStationList.add(stationListBean.get(i).getStationName());
                                }
                            }
                            if (upStationList.size()!=0||downStationList.size()!=0){
                                downStation = downStationList.get(0)+"—"+downStationList.get(downStationList.size()-3)
                                        +"—"+downStationList.get(downStationList.size()-1);
                                upStation = upStationList.get(upStationList.size()-1)+"—"+upStationList.get(upStationList.size()-3)
                                        +"—"+upStationList.get(0);
                            }
                            List<String> dialogList = new ArrayList<String>();
                            dialogList.add(downStation);
                            dialogList.add(upStation);
                            new AlertDialogUtil(getActivity()).showListDialog(dialogList, new AlertDialogCallBack() {
                                @Override
                                public int getData(int s) {
                                    return s;
                                }

                                @Override
                                public void confirm() {

                                }

                                @Override
                                public void cancel() {

                                }
                            });
                        }
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        editQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                List<SaveLinelist> lineList1 = DataSupport.where("lineName like ?", "%" + s.toString() + "%").find(SaveLinelist.class);
                if (lineList1.size() != 0) {
                    lineList.clear();
                    for (int i = 0; i < lineList1.size(); i++) {
                        lineList.add(lineList1.get(i));
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //回调查询站点
    @Override
    public void setLineBean(LineBean lineBean) {
        LineBean lineBean1 = new LineBean();
        List<LineListBean> lineListBean = new ArrayList<>();
        for (int i = 0; i < lineBean.getLineList().size(); i++) {
            LineListBean listBean = new LineListBean();
            listBean.setSxx(lineBean.getLineList().get(i).getSxx());
            listBean.setLineCode(lineCode);
            listBean.setLineName(lineName);
            listBean.setBeginStation(lineBean.getLineList().get(i).getBeginStation());
            listBean.setEndStation(lineBean.getLineList().get(i).getEndStation());
            listBean.setGid(Long.toString(new Date().getTime()));
            //城市code
            listBean.setCityCode("340500");
            lineBean.save();
            lineListBean.add(listBean);
            lineBean1.setLineList(lineListBean);
            lineBean1.save();
        }

        //设定线路:确定上下行起止站点
        Collection<Float> upDisList = new ArrayList<Float>();//上行站点间距
        Collection<Float> downDisList = new ArrayList<Float>();//下行站点间距
        List<StationListBean> stationListBeen = new ArrayList<>();
        for (int j = 0; j < lineBean.getStationList().size(); j++) {
            StationListBean stationListBean = new StationListBean();
            stationListBean.setStaDis(lineBean.getStationList().get(j).getStaDis());//站点间距
            stationListBean.setStationName(lineBean.getStationList().get(j).getStationName());
            stationListBean.setCityCode("340500");
            stationListBean.setLon(lineBean.getStationList().get(j).getLon());
            stationListBean.setLat(lineBean.getStationList().get(j).getLat());
            stationListBean.setLineCode(lineCode);//线路
            stationListBean.setSxx(lineBean.getStationList().get(j).getSxx());//上下行
            if (lineBean.getStationList().get(j).getSxx().equals("0")) {
                downDisList.add(Float.parseFloat(lineBean.getStationList().get(j).getStaDis()));
            } else {
                upDisList.add(Float.parseFloat(lineBean.getStationList().get(j).getStaDis()));
            }
            stationListBean.save();
            stationListBeen.add(stationListBean);
            lineBean1.setStationList(stationListBeen);
            lineBean1.save();
        }

        for (int k = 0; k < lineBean.getBusTimeList().size(); k++) {
            BusTimeListBean busTimeListBean = new BusTimeListBean();
            //首末班发车信息存入本地数据库
            busTimeListBean.setSxx(lineBean.getBusTimeList().get(k).getSxx());
            busTimeListBean.setBeginTime(lineBean.getBusTimeList().get(k).getBeginTime());
            busTimeListBean.setEndTime(lineBean.getBusTimeList().get(k).getEndTime());
            busTimeListBean.setLineCode(lineCode);
            busTimeListBean.save();
        }
    }

    @Override
    public void setLineBeanMessage(String message) {
        Toast.makeText(getActivity(), "查询站点失败", Toast.LENGTH_SHORT).show();
    }
}
