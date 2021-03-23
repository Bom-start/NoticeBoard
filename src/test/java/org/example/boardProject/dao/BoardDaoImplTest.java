package org.example.boardProject.dao;

import org.example.boardProject.component.ConnectionMakerImpl;
import org.example.boardProject.dto.Board;
import org.example.boardProject.dto.PostsUpdatedto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class BoardDaoImplTest {

    BoardDao dao;

    @BeforeEach
    public void SetUp(){
        dao = new BoardDaoImpl(new ConnectionMakerImpl());
    }

    @Test
    void findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Board> list = dao.findAll();
        int beforeSize = list.size();
        Board newBoard = new Board();
        newBoard.setAuthor("author");
        newBoard.setContent("content");
        newBoard.setTitle("title");
        dao.insert(newBoard);
        list = dao.findAll();
        int afterSize = list.size();
        assertThat(afterSize).isEqualTo(beforeSize + 1);
        dao.delete(list.get(afterSize-1).getId());
    }

    @Test
    void findById() throws SQLException, ClassNotFoundException {
        ArrayList<Board> list = dao.findAll();
        Board firstItem = list.get(0);
        Board itemFoundById = dao.findById(firstItem.getId());
        assertThat(itemFoundById.getId()).isEqualTo(firstItem.getId());
        assertThat(itemFoundById.getContent()).isEqualTo(firstItem.getContent());
    }

    @Test
    void insert() throws SQLException, ClassNotFoundException {
        ArrayList<Board> list = dao.findAll();
        int beforeSize = list.size();

        Board newBoard = new Board();
        newBoard.setAuthor("author");
        newBoard.setContent("content");
        newBoard.setTitle("title");
        dao.insert(newBoard);

        list = dao.findAll();
        int afterSize = list.size();
        Board insertedItem = list.get(afterSize-1);

        assertThat(afterSize).isEqualTo(beforeSize + 1);
        assertThat(insertedItem.getTitle()).isEqualTo(insertedItem.getTitle());
        assertThat(insertedItem.getContent()).isEqualTo(insertedItem.getContent());
        dao.delete(insertedItem.getId());
    }

    @Test
    void delete() throws SQLException, ClassNotFoundException {
        Board newBoard = new Board();
        newBoard.setAuthor("author");
        newBoard.setContent("content");
        newBoard.setTitle("title");
        dao.insert(newBoard);
        int beforeDelete = dao.findAll().size();
        newBoard = dao.findAll().get(beforeDelete - 1);

        dao.delete(newBoard.getId());
        int afterDelete = dao.findAll().size();

        assertThat(afterDelete).isEqualTo(beforeDelete - 1);
    }

    @Test
    void update() throws SQLException, ClassNotFoundException {
        Board newBoard = new Board();
        newBoard.setAuthor("author");
        newBoard.setContent("content");
        newBoard.setTitle("title");
        dao.insert(newBoard);

        ArrayList<Board> list = dao.findAll();
        newBoard = list.get(list.size() - 1);

        PostsUpdatedto dto = PostsUpdatedto.builder()
                .author("updatedAuthor")
                .title("updatedTitle")
                .content("updatedContent")
                .build();

        dao.update(newBoard.getId(),dto);

        Board updatedBoard = dao.findById(newBoard.getId());
        assertThat(updatedBoard.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(updatedBoard.getTitle()).isEqualTo(dto.getTitle());
        assertThat(updatedBoard.getContent()).isEqualTo(dto.getContent());

        dao.delete(updatedBoard.getId());
    }
}