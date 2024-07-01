package com.example.RestTemplatedemo.Dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.Date;

public class BlogDto {

    private Long id;

    private String title;

    private String body;

    private Date serverDateTime;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BlogDto(Long id, String title, String body, Date serverDateTime) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.serverDateTime = serverDateTime;
    }
    public BlogDto(){

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setServerDateTime(Date serverDateTime) {
        this.serverDateTime = serverDateTime;
    }

    public String getTitle() {
        return title;
    }

    public Date getServerDateTime() {
        return serverDateTime;
    }

    public String getBody(){
        return body;
    }
}
