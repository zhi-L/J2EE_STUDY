package JDBC.domain;


import java.util.Date;

/**
 * @program: J2EE_STUDY
 * @description:
 * @author: Rodger Luo
 * @create: 2019-07-22 01:15
 **/
public class Shohin {

    /*
    在没有提供构造函数的时候，会默认提供无参构造函数
    当自定义有参数的构造函数后，默认的构造函数不在存在
    需要自定义一个无参构造函数
     */
    public Shohin() {}

    public Shohin(String shohinId, String shohinMei, String shohinBunri, Integer hanbaiTanka, Integer shiireTanka, Date torokubi) {
        this.shohinId = shohinId;
        this.shohinMei = shohinMei;
        this.shohinBunri = shohinBunri;
        this.hanbaiTanka = hanbaiTanka;
        this.shiireTanka = shiireTanka;
        this.torokubi = torokubi;
    }

    private String shohinId;
    private String shohinMei;
    private String shohinBunri;
    private Integer hanbaiTanka;
    private Integer shiireTanka;
    private Date torokubi;

    @Override
    public String toString() {
        return shohinId + "  " + shohinMei + "  " + shohinBunri + "  " + String.valueOf(hanbaiTanka) + "  " + String.valueOf(shiireTanka) + "  " + String.valueOf(torokubi);
    }


    public String getShohinId() {
        return shohinId;
    }

    public void setShohinId(String shohinId) {
        this.shohinId = shohinId;
    }

    public String getShohinMei() {
        return shohinMei;
    }

    public void setShohinMei(String shohinMei) {
        this.shohinMei = shohinMei;
    }

    public String getShohinBunri() {
        return shohinBunri;
    }

    public void setShohinBunri(String shohinBunri) {
        this.shohinBunri = shohinBunri;
    }

    public Integer getHanbaiTanka() {
        return hanbaiTanka;
    }

    public void setHanbaiTanka(Integer hanbaiTanka) {
        this.hanbaiTanka = hanbaiTanka;
    }

    public Integer getShiireTanka() {
        return shiireTanka;
    }

    public void setShiireTanka(Integer shiireTanka) {
        this.shiireTanka = shiireTanka;
    }

    public Date getTorokubi() {
        return torokubi;
    }

    public void setTorokubi(Date tororkubi) {
        this.torokubi = tororkubi;
    }
}
