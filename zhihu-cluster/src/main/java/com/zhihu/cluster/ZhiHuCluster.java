package com.zhihu.cluster;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gurongjing on 2017/4/17.
 */
public class ZhiHuCluster {
//    Properties prop =  new  Properties();
//    InputStream in = getClass().getResourceAsStream("zhihuCluster.properties");
//    prop.load(in);

    SparkConf sparkConf = new SparkConf().setAppName("").setMaster("");
    JavaSparkContext sc = new JavaSparkContext(sparkConf);

    List<Integer> datas = Arrays.asList(1,2,3,4,5,6,7,8);
    JavaRDD<Integer> distData =sc.parallelize(datas);
    JavaRDD<String> distFile = sc.textFile("data.txt");

    //SparkConf
//    public static void main(String[] args) throws Exception {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello World!");
//            }
//        }).start();
//        TimeUnit.SECONDS.sleep(1000);
//    }
}
