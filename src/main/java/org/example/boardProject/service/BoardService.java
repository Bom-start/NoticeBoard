package org.example.boardProject.service;

import org.example.boardProject.dao.BoardDao;
import org.example.boardProject.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class BoardService {

    private final BoardDao boardDao;

    @Autowired
    public BoardService(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    public ArrayList<Board> findAll() throws SQLException, ClassNotFoundException {
        return boardDao.findAll();
    }

    public Board findById(int id) throws SQLException, ClassNotFoundException {
        return boardDao.findById(id);
    }

    public int save(Board board) throws SQLException, ClassNotFoundException {
        return boardDao.insert(board);
    }
}
