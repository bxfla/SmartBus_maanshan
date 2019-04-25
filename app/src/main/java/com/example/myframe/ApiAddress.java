package com.example.myframe;

/**
 * @author: Allen.
 * @date: 2018/3/8
 * @description: 所有接口地址集
 */

public class ApiAddress {

    //生成环境
    public final static String api = "http://123.232.38.10:9999/";

//    //main
//    static String ip = new SharedPreferencesHelper(MyApplication.getContext(),"city").getData(MyApplication.getContext(),"Ip","");
//    static String port = new SharedPreferencesHelper(MyApplication.getContext(),"city").getData(MyApplication.getContext(),"bsPort","");
    public final static String mainApi = "http://220.178.249.25:7080/" ;

    /***********************首页*******************************/
    //城市列表
    public final static String cityList = "androidData";
    //线路列表
    public final static String lineList = "sdhyschedule/PhoneQueryAction!getLineInfo.shtml";
    //站点列表
    public final static String stationList = "sdhyschedule/PhoneQueryAction!getZDXX.shtml";
    //banner
    public final static String banner = "LineServer/docManage/DocManage!jsonModule.action";
    //查询线路信息
    public final static String lineBean = "sdhyschedule/PhoneQueryAction!getLineStation.shtml";

}
