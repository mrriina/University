package com.example.rpo_lab7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Класс, который будет сохранять строку в БД
public class MySQLConnector {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/geolocation";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Метод, который сохраняет строку в БД
    public void saveData(String data) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Загружаем драйвер БД
            Class.forName(DB_DRIVER);

            // Создаем соединение с БД
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            // Создаем подготовленное выражение для выполнения SQL-запроса
            String sql = "INSERT INTO data (location) VALUES (?)";
            stmt = conn.prepareStatement(sql);

            // Устанавливаем значение параметра запроса
            stmt.setString(1, data);

            // Выполняем SQL-запрос
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error: "+e.getMessage());
            e.printStackTrace();
        } finally {
            // Закрываем ресурсы
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}