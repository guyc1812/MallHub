package com.ustc.pro.mallHub.core.impl.service;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import com.ustc.pro.mallHub.core.bean.MallList;
import com.ustc.pro.mallHub.core.bean.MallListMeta;
import com.ustc.pro.mallHub.core.service.MallListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("mallListService")
public class MallListServiceImpl implements MallListService {

    private static final Logger logger = LoggerFactory.getLogger(MallListServiceImpl.class);
    private Environment env;
    private MongoClient mongoClient;


    @Autowired
    public MallListServiceImpl(
            Environment env,
            MongoClient mongoClient){
        this.env = env;
        this.mongoClient = mongoClient;
    }

    MallList MallListConstuctor(){
        MallListMeta m1 = new MallListMeta(
                "/pic/nzan.png",
                "/pic/link.png",
                "林瑞广场",
                "全场双倍积分；\n部分商品五折优惠",
                "linrui",
                "zanLinrui");
        MallListMeta m2 = new MallListMeta(
                "/pic/nzan.png",
                "/pic/jiuguang.png",
                "久光百货",
                "全场双倍积分；\n部分商品五折优惠",
                "jiuguang",
                "zanJiuguang");
        MallListMeta m3 = new MallListMeta(
                "/pic/nzan.png",
                "/pic/meiluo1.png",
                "美罗观前店",
                "满500返50；\n积分抵现金",
                "meiluo1",
                "zanMeiluo1");
        MallListMeta m4 = new MallListMeta(
                "/pic/nzan.png",
                "/pic/xinsu.png",
                "新苏购物",
                "跨店累计金额；\n全场满减送券",
                "xinsu",
                "zanXinsu");
        MallListMeta m5 = new MallListMeta(
                "/pic/nzan.png",
                "/pic/meiluo2.png",
                "美罗新区店",
                "满500返50；\n积分抵现金",
                "meiluo2",
                "zanMeiluo2");
        String[] dis = {"/pic/y1.png","/pic/y2.png","/pic/y3.png"};
        List<MallListMeta> l = new ArrayList<>();
        l.add(m1);
        l.add(m2);
        l.add(m3);
        l.add(m4);
        l.add(m5);
        MallList mallList = new MallList(dis,l);
        return mallList;
    }

    public void MallListSaveToDB(){

        MallList mallList = MallListConstuctor();

        DB db = mongoClient.getDB("SUZHOU");
        DBCollection collection = db.getCollection("MallList");

        Gson gson = new Gson();
        String repoListMeta =  gson.toJson(mallList,MallList.class);

        logger.info("==========>\n\t\t\t MallList adding....");
        collection.remove(new BasicDBObject());
        DBObject dbObject =(DBObject) JSON.parse(repoListMeta);
        collection.insert(dbObject);
        logger.info("==========>\n\t\t\t MallList adding done....");
    }

    public MallList MallListSearch() throws Exception{
        List<MallList> list = new ArrayList<>();
        DB db = mongoClient.getDB("SUZHOU");
        if(db.collectionExists("MallList")){
            DBCollection collection = db.getCollection("MallList");
            DBCursor cur = collection.find();
            Gson gson = new Gson();
            MallList mallList;
            while(cur.hasNext()){
                DBObject obj = cur.next();
                mallList = gson.fromJson(obj.toString(), MallList.class);
                list.add(mallList);
            }
        }
        System.out.print(list.get(0));
        return list.get(0);
    }


}
