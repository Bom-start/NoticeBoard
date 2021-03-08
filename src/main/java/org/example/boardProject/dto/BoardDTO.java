package org.example.boardProject.dto;

import java.util.Date;

public class BoardDTO {
    private int id;
    private String author;
    private String title;
    private String content;
    private Date readDate;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
    public Date getReadDate(){
        return readDate;
    }
    public void setReadDate(Date readDate){
        this.readDate = readDate;
    }
}
