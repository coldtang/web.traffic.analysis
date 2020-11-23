package com.tang.metadata.api.impl;

import com.mongodb.Block;
import com.mongodb.client.MongoDatabase;
import com.tang.metadata.MongoDB;
import com.tang.metadata.api.ProfileConfigManager;
import com.tang.metadata.model.TargetPage;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class MongoProfileConfigManager implements ProfileConfigManager {

    /**
     * 从mongo中加载所有的目标页面配置(写死配置)
     * @return
     */
    @Override
    public List<TargetPage> loadAllTargetPagesConfig() {
        final List<TargetPage> targetPages = new ArrayList<TargetPage>();

//        MongoDatabase database = MongoDB.getMongoDatabase("web-analysis");
//        database.getCollection("TargetPage").find().forEach(new Block<Document>() {
//            @Override
//            public void apply(Document document) {
//                TargetPage targetPage = new TargetPage();
//                targetPage.setId(document.getString("Id"));
//                targetPage.setProfileId(document.getInteger("ProfileId"));
//                targetPage.setName(document.getString("Name"));
//                targetPage.setDescription(document.getString("Description"));
//                targetPage.setMatchPattern(document.getString("MatchPattern"));
//                targetPage.setMatchType(document.getString("MatchType"));
//                targetPage.setMatchWithoutQueryString(document.getBoolean("MatchWithoutQueryString"));
//                targetPage.setEnable(!document.getBoolean("IsDisabled"));
//
//                targetPages.add(targetPage);
//            }
//        });

        TargetPage targetPage = new TargetPage();
        targetPage.setEnable(true);
        targetPage.setMatchWithoutQueryString(false);
        targetPage.setMatchType("CONTAINS");
        targetPage.setMatchPattern("/checkoutLogin");
        targetPage.setProfileId(702);
        targetPage.setId("57f8df278a4bf51e2d834be9");
        targetPage.setName("test target");
        targetPage.setDescription("");
        targetPages.add(targetPage);

        targetPage = new TargetPage();
        targetPage.setEnable(true);
        targetPage.setMatchWithoutQueryString(false);
        targetPage.setMatchType("CONTAINS");
        targetPage.setMatchPattern("/haier_regUser3");
        targetPage.setProfileId(524);
        targetPage.setId("57f8df278a4bf51e2d834be8");
        targetPage.setName("test");
        targetPage.setDescription("");
        targetPages.add(targetPage);

        return targetPages;
    }
}
