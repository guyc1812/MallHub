package com.ustc.pro.mallHub.controller;

import com.google.gson.Gson;
import com.ustc.pro.mallHub.core.bean.MallInfo;
import com.ustc.pro.mallHub.core.bean.MallList;
import com.ustc.pro.mallHub.core.service.MallInfoService;
import com.ustc.pro.mallHub.core.service.MallListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class MallInfoController {

    private MallListService mallListService;
    private MallInfoService mallInfoService;
    @Autowired
    public MallInfoController(MallListService mallListService,
                              MallInfoService mallInfoService) {
        this.mallListService = mallListService;
        this.mallInfoService = mallInfoService;
    }


    @RequestMapping("/saveMallInfo")
    public String SaveMallInfo() {

        try{
            mallInfoService.MallInfoSaveToDB();
        } catch (Exception e){
            e.printStackTrace();
        }

        String res = "Save Done";
        return res;
    }


    @RequestMapping("/searchMallInfo")
    public String SearchMallInfo(HttpServletRequest request) {

        String id = request.getParameter("id");
        MallInfo mallInfo = null;
        try{
            mallInfo = mallInfoService.MallInfoSearch(id);
        } catch (Exception e){
            e.printStackTrace();
        }

        String res = new Gson().toJson(mallInfo);
        return res;
    }

}
