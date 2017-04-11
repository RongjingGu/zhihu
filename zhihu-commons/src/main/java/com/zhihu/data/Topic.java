package com.zhihu.data;

import java.util.List;

/**
 * Created by Gurongjing on 2017/4/11
 */
public class Topic {

    private Integer topicId;
    private String topicName;
    private Integer followers;
    private String discrible;
    private List<String> fatherTopicsNames;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public String getDiscrible() {
        return discrible;
    }

    public void setDiscrible(String discrible) {
        this.discrible = discrible;
    }

    public List<String> getFatherTopicsNames() {
        return fatherTopicsNames;
    }

    public void setFatherTopicsNames(List<String> fatherTopicsNames) {
        this.fatherTopicsNames = fatherTopicsNames;
    }
}
