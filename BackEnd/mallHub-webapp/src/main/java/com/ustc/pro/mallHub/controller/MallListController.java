package com.ustc.pro.mallHub.controller;

import com.google.gson.Gson;
import com.ustc.pro.mallHub.core.bean.MallList;
import com.ustc.pro.mallHub.core.service.MallListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MallListController {

    private MallListService mallListService;
    @Autowired
    public MallListController(MallListService mallListService) {
        this.mallListService = mallListService;
    }


    @RequestMapping("/save")
    public String Save() {

        try{
            mallListService.MallListSaveToDB();
        } catch (Exception e){
            e.printStackTrace();
        }

        String res = "Save Done";
        return res;
    }

    @RequestMapping("/searchMalls")
    public String SearchMalls() {

        MallList mallList = null;
        try {
            mallList = mallListService.MallListSearch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String res = new Gson().toJson(mallList);
        return res;
    }


}
