package dao;

import conexaojdbc.SingleConnection;
import model.UserPosJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserPosDAO {
    private Connection connection;

    public UserPosDAO() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(UserPosJava userPosJava) throws SQLException {
        try {
            String sql = "insert into userposjava(id, nome, email) values(?,?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setLong(1,3);
            insert.setString(2, "Caio");
            insert.setString(3,"caio@email.com");
            insert.execute();
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
