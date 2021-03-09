package org.example.boardProject.dao;

import org.example.boardProject.component.ConnectionMaker;
import org.example.boardProject.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{

    @Autowired
    private ConnectionMaker connectionMaker;

    @Override
    public ArrayList<Board> findAll() throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("select * from Board");
        ResultSet rs = ps.executeQuery();
        ArrayList<Board> boardList = toList(rs);
        rs.close();
        ps.close();
        c.close();
        return boardList;
    }

    @Override
    public Board findById(int id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("select * from Board where id = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        ArrayList<Board> boardList = toList(rs);
        rs.close();
        ps.close();
        c.close();
        return boardList.get(0);
    }

    @Override
    public int insert(Board board) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("insert into Board(title,author,content,readDate) values(?,?,?,?)");
        ps.setString(1,board.getTitle());
        ps.setString(2,board.getAuthor());
        ps.setString(3,board.getContent());
        ps.setDate(4,board.getReadDate());
        int affected = ps.executeUpdate();

        ps.close();
        c.close();
        return affected;
    }

    public ArrayList<Board> toList(ResultSet rs) throws SQLException {
        ArrayList<Board> boardList = new ArrayList<>();
        while(rs.next()){
            Board board = new Board();
            board.setId(rs.getInt("id"));
            board.setTitle(rs.getString("title"));
            board.setAuthor(rs.getString("author"));
            board.setContent(rs.getString("content"));
            board.setReadDate(rs.getDate("readDate"));
            boardList.add(board);
        }
        return boardList;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        return connectionMaker.getConnection();
    }
}
