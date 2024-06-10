package dao;

import conexaojdbc.SingleConnection;
import model.UserPosJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPosDAO {
    private Connection connection;

    public UserPosDAO() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(UserPosJava userPosJava) throws SQLException {
        try {
            String sql = "insert into userposjava( nome, email) values(?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);

            insert.setString(1, userPosJava.getNome());
            insert.setString(2, userPosJava.getEmail());
            insert.execute();
            connection.commit();
        }catch (Exception e){
            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public List<UserPosJava> listar () throws Exception{
        List<UserPosJava> list = new ArrayList<UserPosJava>();
        String sql = "select * from userposjava";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();

        while(resultado.next()){
            UserPosJava userPosJava = new UserPosJava();
            userPosJava.setId(resultado.getLong("id"));
            userPosJava.setNome(resultado.getString("nome"));
            userPosJava.setEmail(resultado.getString("email"));

            list.add(userPosJava);
        }
        return list;
    }

    public UserPosJava buscar(Long id) throws Exception {
        UserPosJava retorno = null;
        String sql = "SELECT * FROM userposjava WHERE id = " + id;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultado = statement.executeQuery()) {
                while (resultado.next()) {
                    retorno = new UserPosJava();
                    retorno.setId(resultado.getLong("id"));
                    retorno.setNome(resultado.getString("nome"));
                    retorno.setEmail(resultado.getString("email"));
                }
            }
        }
        return retorno;
    }


    public void atualizar(UserPosJava userPosJava) {
        try {
            String sql = "update userposjava set nome = ? where id = " + userPosJava.getId();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userPosJava.getNome());

            statement.execute();
            connection.commit();
        }catch (Exception e){
            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public void deletar(Long id){
        try{
            String sql = "delete from userposjava where id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            connection.commit();
        }catch (Exception e){
            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }


}
