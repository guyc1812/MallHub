package com.ustc.pro.mallHub.core.bean;

/**
 * Created by apple on 2017/5/29.
 */
public class MallInfo {

    private String type;
    private String name;
    private String logo;
    private String address;
    private String time;
    private String mail;
    private String hotLine;
    private String park;
    private String bus;
    private String[] discount;
    private String discountDisplay;
    private String latitude;
    private String longitude;
    private String scale;

    public MallInfo(String name, String logo, String address, String time, String mail, String hotLine, String park, String bus, String[] discount, String discountDisplay, String latitude, String longitude, String scale) {
        this.type = "MallInfo";
        this.name = name;
        this.logo = logo;
        this.address = address;
        this.time = time;
        this.mail = mail;
        this.hotLine = hotLine;
        this.park = park;
        this.bus = bus;
        this.discount = discount;
        this.discountDisplay = discountDisplay;
        this.latitude = latitude;
        this.longitude = longitude;
        this.scale = scale;
    }
}
