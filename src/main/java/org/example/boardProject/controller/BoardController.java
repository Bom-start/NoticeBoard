package org.example.boardProject.controller;

import org.example.boardProject.dao.BoardDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class BoardController {

    @GetMapping("/list")
    public String List(Model model) throws SQLException, ClassNotFoundException {
        BoardDao boardDao = new BoardDao();
        model.addAttribute("BoardDTO",boardDao.getAll());
        return "list";
    }
}
