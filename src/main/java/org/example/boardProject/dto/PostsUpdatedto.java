package org.example.boardProject.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Getter
@NoArgsConstructor
public class PostsUpdatedto {
    private String title;
    private String content;
    private String author;
    private Date readDate;


    @Builder
    public PostsUpdatedto(String title,String content,String author,Date readDate){
        this.title=title;
        this.content=content;
        this.author=author;
        this.readDate=readDate;

    }
}
