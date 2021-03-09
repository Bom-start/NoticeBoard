package org.example.boardProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class Board {
    private int id;
    private String author;
    private String title;
    private String content;
    private Date readDate;
}
