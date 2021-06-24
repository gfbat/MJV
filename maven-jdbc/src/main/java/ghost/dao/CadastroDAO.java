package ghost.dao;

import ghost.connection.jdbc.ConnectionManager;
import ghost.model.Cadastro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cadastro.getNome());
            statement.setLong(2, cadastro.getTelefone());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void alterar(Cadastro cadastro){
        try {
            String sql = "UPDATE public.tb_mjv SET nome=?, telefone=? WHERE id=?;";
            PreparedStatement statement =  connection.prepareStatement(sql);
            statement.setString(1, cadastro.getNome());
            statement.setLong(2, cadastro.getTelefone());
            statement.setInt(3, cadastro.getId());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Cadastro> listar(){
        List<Cadastro> cadastros = new ArrayList<Cadastro>();
        try{
            String sql = "SELECT * FROM public.tb_mjv;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                Cadastro cadastro = new Cadastro();
                cadastro.setNome(result.getString("nome"));
                cadastro.setTelefone(result.getLong("telefone"));
                cadastro.setId(result.getInt("id"));
                cadastros.add(cadastro);
            }

            for (Cadastro cadastro: cadastros){
                System.out.println(cadastro.getId() + " | " + cadastro.getNome() + " | " +cadastro.getTelefone() );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cadastros;
    }

    public void delete(int id){
        try{
            String sql = "DELETE FROM public.tb_mjv WHERE id=?;";
            PreparedStatement statement =  connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
