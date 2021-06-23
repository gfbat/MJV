package ghost.dao;

import ghost.connection.jdbc.ConnectionManager;
import ghost.model.Cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastroDAO {
    private Connection connection;

    public CadastroDAO (){
        ConnectionManager cm = new ConnectionManager();
        connection = cm.criarConexao();
    }

    public void incluir(Cadastro cadastro){
        //connection.close();
        try {
            String sql = "INSERT INTO public.tb_mjv (nome, telefone) VALUES (?, ?);";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, cadastro.getNome());
            insert.setLong(2, cadastro.getTelefone());
            insert.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void alterar(){
        //connection.close();
    }

}
