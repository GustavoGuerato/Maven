package org.cursoJdev;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.UserPosJava;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class testejdbc  {

    @Test
    public void initBanco() throws SQLException {
        UserPosDAO userPosDAO = new UserPosDAO();
        UserPosJava userPosJava = new UserPosJava();

        userPosJava.setId(4L);
        userPosJava.setNome("mateus");
        userPosJava.setEmail("mateus@gmail.com");

        userPosDAO.salvar(userPosJava);
    }

    @Test
    public void initListar() throws Exception {
        UserPosDAO dao = new UserPosDAO();
        try{
            List<UserPosJava> list = dao.listar();
            for (UserPosJava userPosJava : list){
                System.out.println(userPosJava);
                System.out.println("-----------------");
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

    }
}
