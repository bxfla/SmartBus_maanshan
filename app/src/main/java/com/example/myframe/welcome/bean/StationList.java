package com.example.myframe.welcome.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/11.
 */

public class StationList extends DataSupport implements Serializable {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * XL : 1
         * XLMC : 1
         * ZD : 1
         * ZDNAME : 椹瀺灞变笢绔�
         * SXX : 0
         * JD : 71121039
         * WD : 19015673
         */

        private String XL;
        private String XLMC;
        private int ZD;
        private String ZDNAME;
        private String SXX;
        private String JD;
        private String WD;

        public String getXL() {
            return XL;
        }

        public void setXL(String XL) {
            this.XL = XL;
        }

        public String getXLMC() {
            return XLMC;
        }

        public void setXLMC(String XLMC) {
            this.XLMC = XLMC;
        }

        public int getZD() {
            return ZD;
        }

        public void setZD(int ZD) {
            this.ZD = ZD;
        }

        public String getZDNAME() {
            return ZDNAME;
        }

        public void setZDNAME(String ZDNAME) {
            this.ZDNAME = ZDNAME;
        }

        public String getSXX() {
            return SXX;
        }

        public void setSXX(String SXX) {
            this.SXX = SXX;
        }

        public String getJD() {
            return JD;
        }

        public void setJD(String JD) {
            this.JD = JD;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }
    }
}
