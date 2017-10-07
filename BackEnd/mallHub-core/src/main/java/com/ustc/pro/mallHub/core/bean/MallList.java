package com.ustc.pro.mallHub.core.bean;

import java.util.List;

/**
 * Created by apple on 2017/5/29.
 */
public class MallList {

    private String[] discountDisplay;
    private List <MallListMeta> mallList;

    public MallList(String[] discountDisplay, List<MallListMeta> mallList) {
        this.discountDisplay = discountDisplay;
        this.mallList = mallList;
    }
}
