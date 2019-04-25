package com.example.myframe.http.utils;

import android.util.Log;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class MainUtil {
    public static String logger = "logger";
    private static boolean isPrintLog = true; //是否打开日志打印

    //日志打印
    public static void printLogger(String logTxt) {
        if (isPrintLog) {
            Log.d(logger, logTxt);
        }
    }

    //成功的code
    public static int SUCCESS_CODE = 200;

    public static String loadTxt = "正在加载";
    public static String loadLogin = "正在登录";
    public static String getData = "获取数据中";

}
