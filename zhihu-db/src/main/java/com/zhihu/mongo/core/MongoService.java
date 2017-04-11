package com.zhihu.mongo.core;

import com.mongodb.MongoClient;
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
            mongoClient = new MongoClient("127.0.0.1",27017);
        }catch (Exception e){
            _logger.log(Level.SEVERE,e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
