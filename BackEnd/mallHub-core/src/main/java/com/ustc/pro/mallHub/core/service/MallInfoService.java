package com.ustc.pro.mallHub.core.service;

import com.google.gson.Gson;
import com.ustc.pro.mallHub.core.bean.MallInfo;

public interface MallInfoService {

     void MallInfoSaveToDB()throws Exception;
     MallInfo MallInfoSearch(String mallName) throws Exception;

}
