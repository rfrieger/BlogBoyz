package com.blogBoys.blogBoys.models;

public class CommentRequest {

    Integer commment_Id;
    String content;

    public Integer getCommment_Id() {
        return commment_Id;
    }

    public void setCommment_Id(Integer commment_Id) {
        this.commment_Id = commment_Id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
