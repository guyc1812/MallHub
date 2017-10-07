package com.ustc.pro.mallHub.core.impl.service;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import com.ustc.pro.mallHub.core.bean.MallInfo;
import com.ustc.pro.mallHub.core.service.MallInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("mallInfoService")
public class MallInfoServiceImp implements MallInfoService {

    private static final Logger logger = LoggerFactory.getLogger(MallListServiceImpl.class);
    private Environment env;
    private MongoClient mongoClient;


    @Autowired
    public MallInfoServiceImp(
            Environment env,
            MongoClient mongoClient){
        this.env = env;
        this.mongoClient = mongoClient;
    }


    private MallInfo LinruiMallInfo(){
        String[] disCount = {"全场限时八折优惠","累计满500返70","会员三倍积分"};
        MallInfo mallInfo = new MallInfo(
                "邻瑞广场",
                "/pic/link.png",
                "工业园区西华林街88号",
                "10:00 - 22:00 ",
                "customerservice@link-city.cn",
                "400-8840-100",
                "地下停车场",
                "邻瑞广场站：205、178；邻瑞广场北站：18、27、52、100、118、126、141、142、146、168、218、518",
                disCount,
                "",
                "31.303533",
                "120.725239",
                "18"
        );
        return mallInfo;
    }

    private MallInfo JiuguangMallInfo(){
        String[] disCount = {"全场限时八折优惠","累计满500返70","会员三倍积分"};
        MallInfo mallInfo = new MallInfo(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                disCount,
                "",
                "",
                "",
                ""
        );
        return mallInfo;
    }

    public void MallInfoSaveToDB()throws Exception{
        MallInfo linrui = LinruiMallInfo();
        DB db = mongoClient.getDB("SUZHOU");
        DBCollection collection = db.getCollection("linrui");
        Gson gson = new Gson();
        String linruiJson =  gson.toJson(linrui,MallInfo.class);
        logger.info("==========>\n\t\t\t MallList adding....");
        collection.remove(new BasicDBObject());
        DBObject dbObject =(DBObject) JSON.parse(linruiJson);
        collection.insert(dbObject);
        logger.info("==========>\n\t\t\t MallList adding done....");
    }

    public MallInfo MallInfoSearch(String mallName) throws Exception{
        MallInfo mallInfo = null;
        DB db = mongoClient.getDB("SUZHOU");
        if(db.collectionExists(mallName)){
            DBCollection collection = db.getCollection(mallName);
            BasicDBObject queryObject = new BasicDBObject("type","MallInfo");
            DBObject obj = collection.findOne(queryObject);
            Gson gson = new Gson();
            mallInfo = gson.fromJson(obj.toString(), MallInfo.class);
        }else {
            return null;
        }
        System.out.print(mallInfo);
        return mallInfo;
    }

}
