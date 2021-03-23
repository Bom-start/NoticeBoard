package org.example.boardProject.service;

import lombok.RequiredArgsConstructor;
import org.example.boardProject.dao.BoardDao;
import org.example.boardProject.dto.Board;
import org.example.boardProject.dto.PostsUpdatedto;
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


    public int update(int id, PostsUpdatedto requestDto) throws SQLException, ClassNotFoundException {
        Board board = boardDao.findById(id);
//                .orElseThrow(()-> new
//                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        boardDao.update(id,requestDto);
        return id;
    }

    public void delete(int id) throws SQLException,ClassNotFoundException{
        Board board = boardDao.findById(id);
        boardDao.delete(id);

    }
}
