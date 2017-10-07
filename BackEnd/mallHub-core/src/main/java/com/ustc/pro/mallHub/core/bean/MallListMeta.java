package com.ustc.pro.mallHub.core.bean;

/**
 * Created by apple on 2017/5/30.
 */
public class MallListMeta {

    private String type;
    private String zzsrc;
    private String src;
    private String name;
    private String describe;
    private String tap;
    private String zanTap;

    public MallListMeta(String zzsrc, String src, String name, String describe, String tap, String zanTap) {
        this.type = "MallListMeta";
        this.zzsrc = zzsrc;
        this.src = src;
        this.name = name;
        this.describe = describe;
        this.tap = tap;
        this.zanTap = zanTap;
    }
}
