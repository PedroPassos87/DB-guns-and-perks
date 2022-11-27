package br.inatel.POOBD.controller;

import java.sql.*;


public abstract class Database {
    Connection connection;  //objeto responsavel por fazer a conexap cpm o servidor do MySql
    Statement statement;    //objeto responsavel por preparar consultas *SELECT*
    ResultSet result;       //objeto responsavel por executar consultas *SELECT*
    PreparedStatement pst;  //objeto responsavel por preparar querys de manipulação dinâmicas(INSERT , UPDATE,DELETE)

    static final String user = "root";         //usuario da instancai local do servidor
    static final String password = "PacificFilly87";
    static final String database = "projeto";  //nome do banco de dados a ser utilizado

    //string com URL de conexão com o servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";


    public void connect(){
        try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Conexao feita com sucesso"+connection);
        }catch (SQLException e){
            System.err.println("Erro de conexao: " +e.getMessage());
        }


    }

}
