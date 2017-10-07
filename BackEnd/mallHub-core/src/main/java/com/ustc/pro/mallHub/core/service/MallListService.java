package com.ustc.pro.mallHub.core.service;

import com.ustc.pro.mallHub.core.bean.MallList;
import com.ustc.pro.mallHub.core.bean.MallListMeta;

/**
 * Created by apple on 2017/5/30.
 */
public interface MallListService {

    void MallListSaveToDB() throws Exception;
    MallList MallListSearch() throws Exception;
}
