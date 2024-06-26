package org.cursoJdev;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.BeanUserForm;
import model.Telefone;
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

    @Test
    public void testeInserTelefone(){
        Telefone telefone = new Telefone();
        telefone.setNumero("(11)3920134812");
        telefone.setTipo("Casa");
        telefone.setUsuario(3L);

        UserPosDAO dao = new UserPosDAO();
        dao.salvarTelefone(telefone);
    }


    @Test

    public void testeCarregaFonesUser(){
        UserPosDAO dao = new UserPosDAO();

        List<BeanUserForm> beanUserForms = dao.listtaUserFone(3L);
        for (BeanUserForm beanUserForm : beanUserForms) {
            System.out.println(beanUserForm);
            System.out.println("------------");
        }

    }

    @Test
    public void testeDeleteUserFone(){
        UserPosDAO dao = new UserPosDAO();
        dao.deleteFonesPorUser(2L);
    }
}
