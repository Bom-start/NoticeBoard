package org.example.boardProject.controller;
import org.example.boardProject.dto.Board;
import org.example.boardProject.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String list(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("board",boardService.findAll());
        return "index";
    }

    @GetMapping("/board/{id}")
    public String update(@PathVariable int id, Model model) throws SQLException, ClassNotFoundException {
        Board board = boardService.findById(id);
        model.addAttribute("board",board);
        return "update";
    }

    @GetMapping("/board/save")
    public String save() {
        return "save";
    }
}
