package com.example.myframe.http.network;


import com.example.myframe.ApiAddress;
import com.example.myframe.bus.bean.LineBean;
import com.example.myframe.main.bean.Banner;
import com.example.myframe.welcome.bean.CityList;
import com.example.myframe.welcome.bean.LineList;
import com.example.myframe.welcome.bean.StationList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public interface AllApi {

    /**
     * 获取城市列表
     */
    @GET(ApiAddress.cityList)
    Observable<List<CityList>> getCityList();

    /**
     * 获取线路列表
     */
    @GET(ApiAddress.lineList)
    Observable<LineList> getLineList();

    /**
     * 获取站点列表
     */
    @GET(ApiAddress.stationList)
    Observable<StationList> getStationList();

    /**
     * 获取banner
     */
    @GET(ApiAddress.banner)
    Observable<Banner> getBanner();

//    /**
//     * 获取查询线路信息
//     */
//    @HTTP(method = "DELETE",path = ApiAddress.lineBean,hasBody = true)
//    Observable<LineBean> getLineBean(@Body Map<String, String> maps);
    /**
     * 获取查询线路信息
     */
    @POST(ApiAddress.lineBean)
    Observable<LineBean> getLineBean(@Query("lineCode") String lineCode);

}
