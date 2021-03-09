package org.example.boardProject.controller;

import org.example.boardProject.dto.Board;
import org.example.boardProject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
public class BoardApiController {

    private final BoardService boardService;

    @Autowired
    public BoardApiController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("/board/api/save")
    public int save(@RequestBody Board board) throws SQLException, ClassNotFoundException {
        return boardService.save(board);
    }
}
