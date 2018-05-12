package com.done.entry;

import com.baidu.mapapi.clusterutil.clustering.ClusterItem;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.model.LatLng;

import java.io.Serializable;
import java.util.List;

/**
 * Created by XDONE on 2018/2/9.
 */

public class BusinessCatagoryEntry implements Serializable{


    /**
     * code : 1
     * data : [{"id":5,"business_name":"菊花赵信3123366","business_description":"铲墙一怔8","business_address":"下路草丛buff出","contact_name":"赵信8","contact_phone":"15555555558","email":"4544546@qq.com8","cover_path":"/uploads/picture/20161227/59c34d6938aee5d9c361ffd991970399.jpg","status":1,"regtime":1482738333,"update_time":1516071880,"coin_type":["1"],"remark":"xiaolang8","category_name":2,"country":2,"province":6,"longitude":"112.993288","dimension":"28.227424","point":11,"sort":0},{"id":6,"business_name":"提莫蘑菇店661","business_description":"剑圣，我的剑","business_address":"大阿斯顿撒","contact_name":"","contact_phone":"110","email":"1123465@qq.com","cover_path":"","status":1,"regtime":1482806780,"update_time":1516071771,"coin_type":["1"],"remark":"","category_name":4,"country":1,"province":9,"longitude":"112.984809","dimension":"28.238754","point":11,"sort":6},{"id":7,"business_name":"卖剑","business_description":"剑圣，我的剑，就是你的剑 ","business_address":"下路红buff","contact_name":"剑圣","contact_phone":"123456789","email":"1215615165@qq.com","cover_path":"/uploads/picture/20161227/19b66fba8c9bb8faedc7eb3be57008b1.jpg","status":1,"regtime":1482820141,"update_time":null,"coin_type":["1","43","45"],"remark":"剑圣，我的剑，就是你的剑 ","category_name":1,"country":2,"province":7,"longitude":"100.435265","dimension":"13.644411","point":11,"sort":0},{"id":8,"business_name":"小卡水果店","business_description":"生与死，轮回不止。我们生，而他们死。","business_address":"在湘江中路111号","contact_name":"赵三","contact_phone":"1598745581","email":"5626262651@qq.com","cover_path":"/uploads/picture/20161227/e0eb7d4a592b9bf785ccbc38143bbc38.jpg","status":1,"regtime":1482820578,"update_time":1482977841,"coin_type":["1","45","48"],"remark":"死亡祭祀就要开始。你的内脏将用来占卜。\r\n","category_name":1,"country":2,"province":6,"longitude":"101.478737","dimension":"12.94615","point":11,"sort":0},{"id":9,"business_name":"黑暗之女-安妮","business_description":"你也要来玩儿么？很好玩的哟！","business_address":"萨顶顶撒飒飒","contact_name":"132132","contact_phone":"321321321","email":"321312321321@qq.com","cover_path":"/uploads/picture/20161227/88cdf1a85ce375ef77005238fd0104b0.jpg","status":1,"regtime":1482824769,"update_time":1516071845,"coin_type":["1","45"],"remark":"ewqewq","category_name":1,"country":1,"province":9,"longitude":"112.995407","dimension":"28.236913","point":11,"sort":0},{"id":11,"business_name":"全部1","business_description":"你好！全部大佬","business_address":"全部全部","contact_name":"全部","contact_phone":"1111111111","email":"1111111111@qq.com","cover_path":"","status":1,"regtime":1519714128,"update_time":1519871367,"coin_type":["45","59"],"remark":"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq","category_name":1,"country":1,"province":9,"longitude":"112.984809","dimension":"28.238754","point":11,"sort":0},{"id":12,"business_name":"美食1","business_description":"美食q","business_address":"jjj","contact_name":"美食家","contact_phone":"12345678901","email":"12345678901@qq.com","cover_path":"","status":1,"regtime":1519714288,"update_time":1519871269,"coin_type":["53","68"],"remark":"美食中的美食！！！！","category_name":2,"country":1,"province":9,"longitude":"112.932309","dimension":"28.233234","point":11,"sort":0},{"id":13,"business_name":"酒店11","business_description":"酒店极品！！","business_address":"jk","contact_name":"酒店11","contact_phone":"122222222222","email":"4444444@qq.com","cover_path":"","status":1,"regtime":1519714417,"update_time":1519871223,"coin_type":["68","69"],"remark":"酒店销售6666666","category_name":3,"country":2,"province":6,"longitude":"112.984899","dimension":"28.238763","point":11,"sort":0},{"id":14,"business_name":"休闲","business_description":"休闲中的蓝山","business_address":"55","contact_name":"休闲333","contact_phone":"22222222222","email":"33333333@qq.com","cover_path":"","status":1,"regtime":1519714527,"update_time":1519871190,"coin_type":["59","60"],"remark":"休闲的时代","category_name":4,"country":1,"province":9,"longitude":"112.984449","dimension":"28.238444","point":11,"sort":0},{"id":15,"business_name":"KTV11","business_description":"","business_address":"22","contact_name":"开踢威","contact_phone":"2222222222221","email":"5555555555@qq.com","cover_path":"","status":1,"regtime":1519714621,"update_time":1519871160,"coin_type":["53","61","62"],"remark":"55555","category_name":5,"country":1,"province":9,"longitude":"112.987709","dimension":"28.237754","point":11,"sort":0},{"id":16,"business_name":"周边11","business_description":"周边的天堂","business_address":"55","contact_name":"周边边","contact_phone":"33333333333","email":"6666666@qq.com","cover_path":"","status":1,"regtime":1519714742,"update_time":1519871060,"coin_type":["61","68"],"remark":"周边的天水之境","category_name":6,"country":1,"province":9,"longitude":"112.984855","dimension":"28.238555","point":11,"sort":0},{"id":17,"business_name":"丽人1","business_description":"丽人人","business_address":"hh","contact_name":"丽人","contact_phone":"111111111111111","email":"22222222222@qq.com","cover_path":"","status":1,"regtime":1519714816,"update_time":1519871019,"coin_type":["53","68","69"],"remark":"3333333333","category_name":7,"country":1,"province":9,"longitude":"112.984875","dimension":"28.238775","point":11,"sort":0},{"id":18,"business_name":"美发","business_description":"美发中的靓景","business_address":"hh","contact_name":"美发啦","contact_phone":"444444444444444","email":"666666666@qq.com","cover_path":"","status":1,"regtime":1519714924,"update_time":1519870986,"coin_type":["53","68","69"],"remark":"今天我要剃个关头头","category_name":8,"country":1,"province":9,"longitude":"112.984888","dimension":"28.238788","point":11,"sort":0},{"id":19,"business_name":"电影11","business_description":"电影空化世界","business_address":"jjj","contact_name":"电影","contact_phone":"33333333333","email":"888888888888@qq.com","cover_path":"","status":1,"regtime":1519715022,"update_time":1519870948,"coin_type":["45","53","68"],"remark":"电影中的世界","category_name":9,"country":1,"province":9,"longitude":"112.985809","dimension":"28.238454","point":11,"sort":0}]
     * msg : 操作成功
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean  implements Serializable {
        /**
         * id : 5
         * business_name : 菊花赵信3123366
         * business_description : 铲墙一怔8
         * business_address : 下路草丛buff出
         * contact_name : 赵信8
         * contact_phone : 15555555558
         * email : 4544546@qq.com8
         * cover_path : /uploads/picture/20161227/59c34d6938aee5d9c361ffd991970399.jpg
         * status : 1
         * regtime : 1482738333
         * update_time : 1516071880
         * coin_type : ["1"]
         * remark : xiaolang8
         * category_name : 2
         * country : 2
         * province : 6
         * longitude : 112.993288
         * dimension : 28.227424
         * point : 11
         * sort : 0
         */

        private String id;
        private String business_name;
        private String business_description;
        private String business_address;
        private String contact_name;
        private String contact_phone;
        private String email;
        private String cover_path;
        private String status;
        private String regtime;
        private String update_time;
        private String remark;
        private String category_name;
        private String country;
        private String province;
        private String longitude;
        private String dimension;
        private int point;
        private int sort;
        private List<String> coin_type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBusiness_name() {
            return business_name;
        }

        public void setBusiness_name(String business_name) {
            this.business_name = business_name;
        }

        public String getBusiness_description() {
            return business_description;
        }

        public void setBusiness_description(String business_description) {
            this.business_description = business_description;
        }

        public String getBusiness_address() {
            return business_address;
        }

        public void setBusiness_address(String business_address) {
            this.business_address = business_address;
        }

        public String getContact_name() {
            return contact_name;
        }

        public void setContact_name(String contact_name) {
            this.contact_name = contact_name;
        }

        public String getContact_phone() {
            return contact_phone;
        }

        public void setContact_phone(String contact_phone) {
            this.contact_phone = contact_phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCover_path() {
            return cover_path;
        }

        public void setCover_path(String cover_path) {
            this.cover_path = cover_path;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRegtime() {
            return regtime;
        }

        public void setRegtime(String regtime) {
            this.regtime = regtime;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getDimension() {
            return dimension;
        }

        public void setDimension(String dimension) {
            this.dimension = dimension;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public List<String> getCoin_type() {
            return coin_type;
        }

        public void setCoin_type(List<String> coin_type) {
            this.coin_type = coin_type;
        }
    }
}
