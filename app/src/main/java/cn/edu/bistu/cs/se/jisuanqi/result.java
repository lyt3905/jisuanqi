package cn.edu.bistu.cs.se.jisuanqi;


import com.google.gson.annotations.SerializedName;

public class result {

    public String status;

    public String YuanBiZhong;

    public String MuBiaoBiZhong;

    public String ZhongWenMingCheng;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getYuanBiZhong() {
        return YuanBiZhong;
    }

    public void setYuanBiZhong(String yuanBiZhong) {
        YuanBiZhong = yuanBiZhong;
    }

    public String getMuBiaoBiZhong() {
        return MuBiaoBiZhong;
    }

    public void setMuBiaoBiZhong(String muBiaoBiZhong) {
        MuBiaoBiZhong = muBiaoBiZhong;
    }

    public String getZhongWenMingCheng() {
        return ZhongWenMingCheng;
    }

    public void setZhongWenMingCheng(String zhongWenMingCheng) {
        ZhongWenMingCheng = zhongWenMingCheng;
    }

    public String getHuilv() {
        return huilv;
    }

    public void setHuilv(String huilv) {
        this.huilv = huilv;
    }

    public String getRiQi() {
        return RiQi;
    }

    public void setRiQi(String riQi) {
        RiQi = riQi;
    }

    public String huilv;

    public String RiQi;

}
