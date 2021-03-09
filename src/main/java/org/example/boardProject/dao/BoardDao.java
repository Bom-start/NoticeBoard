package org.example.boardProject.dao;

import org.example.boardProject.dto.Board;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BoardDao {
    ArrayList<Board> findAll() throws ClassNotFoundException, SQLException;
    Board findById(int id) throws ClassNotFoundException, SQLException;
    int insert(Board board) throws SQLException, ClassNotFoundException;
}
