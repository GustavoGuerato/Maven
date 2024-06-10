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


        userPosJava.setNome("Joelinton");
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

    @Test
    public void initBuscar() throws Exception {
        UserPosDAO dao = new UserPosDAO();

        UserPosJava userPosJava = dao.buscar(2L);
    }

    @Test
    public void initAtualizar(){
        UserPosDAO dao = new UserPosDAO();
        try {
            UserPosJava objetoBanco = dao.buscar(1L);

            objetoBanco.setNome("Nome mudado com sucesso");

            dao.atualizar(objetoBanco);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void initDeletar(){
        try {
            UserPosDAO dao = new UserPosDAO();
            dao.deletar(1L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
