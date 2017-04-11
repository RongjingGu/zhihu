package com.zhihu.mongo.core;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.zhihu.data.Topic;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gurongjing on 2017/4/11.
 * gurongjing@163.com
 */
@Component
public class MongoService {
    private static final Logger _logger = Logger.getLogger(MongoService.class.getName());

    private MongoClient mongoClient;

//    ScriptEngineManager sem = new ScriptEngineManager();
//    ScriptEngine engine = sem.getEngineByName("javascript");


    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @PostConstruct
    public void init(){
        try {
            mongoClient = new MongoClient("127.0.0.1",27018);
        }catch (Exception e){
            _logger.log(Level.SEVERE,e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public DB getDataBase(String dataBaseName) throws Exception{
        return mongoClient.getDB(dataBaseName);
    }

    public void dropDataBase(String dataBaseName) throws Exception{
        mongoClient.dropDatabase(dataBaseName);
    }

    public void dropCollection(String databaseName,String collectionName){
        mongoClient.getDB(databaseName).getCollection(collectionName).drop();
    }

    public void insert(String databaseName, String collectionName, BasicDBObject useDocument){
        mongoClient.getDB(databaseName).getCollection(collectionName).insert(useDocument);
    }

    public void insertTopic(String dataBaseName,String collectionName,Topic topic) throws Exception{
        BasicDBObject rowDocument = new BasicDBObject();
        rowDocument.append("topicId",topic.getTopicId());
        rowDocument.append("topicName",topic.getTopicName());
        rowDocument.append("discrible",topic.getDiscrible());

        rowDocument.append("followers",topic.getFollowers());
        rowDocument.append("fatherTopicsNames",topic.getFatherTopicsNames());
        getCollection(dataBaseName,collectionName).insert(rowDocument);
    }

    public static void main(String[] args){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }

    private DBCollection getCollection(String databaseName,
                                       String collectionName) throws Exception {
        return getDataBase(databaseName).getCollection(collectionName);
    }
}
