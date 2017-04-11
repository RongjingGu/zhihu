package com.zhihu.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.zhihu.mongo.core.MongoService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by Gurongjing on 2017/4/11.
 */
public class MongoServiceTest extends TestCase {

    MongoService mongoService = new MongoService();

    public MongoServiceTest(String testName) throws Exception {
        super(testName);
        mongoService.setMongoClient(new MongoClient("127.0.0.1", 27018));
    }

    public static Test suit() {
        return new TestSuite(MongoServiceTest.class);
    }

    @org.junit.Test
    public void testCreatCollection() throws Exception{
        final DBObject cmd = new BasicDBObject("shardcollection", "test.testCollection");
       // cmd.put("key", new BasicDBObject("testkey", "hashed"));
        mongoService.getDataBase("test").command(cmd);
        // db.command(cmd);
    }

    @org.junit.Test
    public void testInsert() {

        for (int i = 0; i < 10; i++) {
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.append("testkey", i);
            newDocument.append("value", i);
            mongoService.insert("zhihu", "collection1", newDocument);
        }
    }

    public void testdropCollection() {
        mongoService.dropCollection("test","testCollection");
    }

}
