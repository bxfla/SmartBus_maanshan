package com.example.myframe.main.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/11.
 */

public class Banner implements Serializable {

    /**
     * Interface : [{"icon":"http://222.133.4.18:8080/LineServer/docManage/sysimage/icon_bike_1483414974772.png","iconType":"1","title":"出行调查","webURL":"http://222.133.4.18:8080/LineServer/DocManage!initTrip.action"},{"icon":"http://222.133.4.18:8080/LineServer/docManage/sysimage/icon_buser_1483414993475.png","iconType":"1","title":"乘客招募","webURL":"http://222.133.4.18:8080/LineServer/DocManage!listTripLineInfoByMode.action"},{"icon":"http://222.133.4.18:8080/LineServer/docManage/sysimage/icon_public_1483413908709.png","iconType":"1","title":"公告","webURL":"http://222.133.4.18:8080/LineServer/docManage/customhtml/1.html"},{"icon":"http://222.133.4.18:8080/LineServer/docManage/sysimage/icon_traffic_1504839793676.png","iconType":"1","title":"帮助","webURL":"http://222.133.4.18:8080/help.html"}]
     * adVersion : 33
     * advertisement : [{"page":"initPage","showType":"0","delay":"0","display":[{"content":"http://220.178.249.25:7080/LineServer/docManage/adimage/gjgg20170204_1486172277997.jpg","webURL":""}]},{"page":"mainPage","showType":"0","delay":"0","display":[{"content":"http://220.178.249.25:7080/LineServer/docManage/adimage/20171211wx_1512978276969.jpg","webURL":"#"},{"content":"http://220.178.249.25:7080/LineServer/docManage/adimage/20171211zsgj_1512977443949.jpg","webURL":"#"},{"content":"http://220.178.249.25:7080/LineServer/docManage/adimage/01_1458976353226.jpg","webURL":"#"}]}]
     */

    private String adVersion;
    private List<InterfaceBean> Interface;
    private List<AdvertisementBean> advertisement;

    public String getAdVersion() {
        return adVersion;
    }

    public void setAdVersion(String adVersion) {
        this.adVersion = adVersion;
    }

    public List<InterfaceBean> getInterface() {
        return Interface;
    }

    public void setInterface(List<InterfaceBean> Interface) {
        this.Interface = Interface;
    }

    public List<AdvertisementBean> getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(List<AdvertisementBean> advertisement) {
        this.advertisement = advertisement;
    }

    public static class InterfaceBean {
        /**
         * icon : http://222.133.4.18:8080/LineServer/docManage/sysimage/icon_bike_1483414974772.png
         * iconType : 1
         * title : 出行调查
         * webURL : http://222.133.4.18:8080/LineServer/DocManage!initTrip.action
         */

        private int icon;
        private String iconType;
        private String title;
        private String webURL;

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public String getIconType() {
            return iconType;
        }

        public void setIconType(String iconType) {
            this.iconType = iconType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getWebURL() {
            return webURL;
        }

        public void setWebURL(String webURL) {
            this.webURL = webURL;
        }
    }

    public static class AdvertisementBean {
        /**
         * page : initPage
         * showType : 0
         * delay : 0
         * display : [{"content":"http://220.178.249.25:7080/LineServer/docManage/adimage/gjgg20170204_1486172277997.jpg","webURL":""}]
         */

        private String page;
        private String showType;
        private String delay;
        private List<DisplayBean> display;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getShowType() {
            return showType;
        }

        public void setShowType(String showType) {
            this.showType = showType;
        }

        public String getDelay() {
            return delay;
        }

        public void setDelay(String delay) {
            this.delay = delay;
        }

        public List<DisplayBean> getDisplay() {
            return display;
        }

        public void setDisplay(List<DisplayBean> display) {
            this.display = display;
        }

        public static class DisplayBean {
            /**
             * content : http://220.178.249.25:7080/LineServer/docManage/adimage/gjgg20170204_1486172277997.jpg
             * webURL :
             */

            private String content;
            private String webURL;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getWebURL() {
                return webURL;
            }

            public void setWebURL(String webURL) {
                this.webURL = webURL;
            }
        }
    }
}
