package org.example.boardProject.dao;

import org.example.boardProject.dto.BoardDTO;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
    public ArrayList<BoardDTO> getAll() throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("select * from Board");

        ArrayList<BoardDTO> boardDTOs = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setId(rs.getInt("id"));
            boardDTO.setTitle(rs.getString("title"));
            boardDTO.setAuthor(rs.getString("author"));
            boardDTO.setContent(rs.getString("content"));
            boardDTO.setReadDate(rs.getDate("readDate"));
            boardDTOs.add(boardDTO);
        }

        rs.close();
        ps.close();
        c.close();
        return boardDTOs;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "","",""
        );
    }
}
