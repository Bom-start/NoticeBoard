package org.example.boardProject.component;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
