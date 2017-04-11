package com.zhihu.core;

import sun.net.www.http.HttpClient;

import java.util.logging.Level;

/**
 * Created by Gurongjing on 2017/4/11
 */
public class PaserHtml {

    public String getResponse(String url){

        return null;
    }

//    private StringBuffer getYDataResponse(String url, String arg) throws Exception {
//        try{
////            if (StringUtil.isEmpty(url)) {
////                throw new CustomException("配置错误，服务名称为空");
////            }
////            _logger.info("url[" + host + url + "?" + arg + "]");
//            RemoteService.getResponse(host + url, "", arg, "POST", "application/x-www-form-urlencoded", out, 200000);
//            _logger.info("response" + out.toString());
////            JSONObject jsonObject = JSONObject.parseObject(out.toString());
////            if (jsonObject != null && !StringUtils.isEmpty(jsonObject.getString("error"))) {
////                throw new CustomException(jsonObject.getString("error"));
////            }
//            return out;
//        } catch (CustomException ex) {
//            throw ex;
//        } catch (Exception e) {
//            _logger.log(Level.FINE, e.getMessage());
//            throw new CustomException("网络连接异常或接口数据错误");
//        }
//    }

}
