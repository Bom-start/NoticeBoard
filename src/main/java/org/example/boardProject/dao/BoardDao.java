package org.example.boardProject.dao;

import org.example.boardProject.dto.Board;
import org.example.boardProject.dto.PostsUpdatedto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BoardDao {
    ArrayList<Board> findAll() throws ClassNotFoundException, SQLException;
    Board findById(int id) throws ClassNotFoundException, SQLException;
    int insert(Board board) throws SQLException, ClassNotFoundException;
    int update(int id, PostsUpdatedto requestdto) throws SQLException, ClassNotFoundException;
    void delete(int id) throws SQLException, ClassNotFoundException;
}
