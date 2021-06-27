package ghost.dao;

import ghost.connection.jdbc.ConnectionManager;
import ghost.model.Cadastro;
import ghost.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO (){
        ConnectionManager cm = new ConnectionManager();
        connection = cm.criarConexaoCliente();
    }

    public void incluir(Cliente cliente){
        //connection.close();
        try {
            String sql = "INSERT INTO public.tb_cliente " +
                    "(codigo, " +
                    "pf_pj, " +
                    "razao_social, " +
                    "cpf_cnpj, " +
                    "inscr_estadual_rg, " +
                    "telefone1, telefone2, " +
                    "email, " +
                    "ativ_profissao, " +
                    "cep, " +
                    "estado," +
                    "cidade," +
                    "rua, " +
                    "numero, " +
                    "complemento, " +
                    "bairro, " +
                    "site_instagram, " +
                    "observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cliente.getCodigo());
            statement.setString(2, cliente.getPfPj());
            statement.setString(3, cliente.getRazaoSocial());
            statement.setString(4, cliente.getCpfCnpj());
            statement.setString(5, cliente.getInscrEstadualRG());
            statement.setLong(6, cliente.getTelefone1());
            statement.setLong(7, cliente.getTelefone2());
            statement.setString(8, cliente.getEmail());
            statement.setString(9, cliente.getAtivProfissao());
            statement.setString(10, cliente.getCep());
            statement.setString(11, cliente.getEstado());
            statement.setString(12, cliente.getCidade());
            statement.setString(13, cliente.getRua());
            statement.setString(14, cliente.getNumero());
            statement.setString(15, cliente.getComplemento());
            statement.setString(16, cliente.getBairro());
            statement.setString(17, cliente.getSiteInstagram());
            statement.setString(18, cliente.getObservacoes());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void alterar(Cliente cliente){
        try {
            String sql = "UPDATE public.tb_cliente SET pf_pj=?, " +
                    "razao_social=?, " +
                    "cpf_cnpj=?, " +
                    "inscr_estadual_rg=?, " +
                    "telefone1=?, telefone2=?, " +
                    "email=?, " +
                    "ativ_profissao=?, " +
                    "cep=?, " +
                    "estado=?," +
                    "cidade=?," +
                    "rua=?, " +
                    "numero=?, " +
                    "complemento=?, " +
                    "bairro=?, " +
                    "site_instagram=?, " +
                    "observacoes=? " +
                    "WHERE codigo=?;";
            PreparedStatement statement =  connection.prepareStatement(sql);
            statement.setString(1, cliente.getPfPj());
            statement.setString(2, cliente.getRazaoSocial());
            statement.setString(3, cliente.getCpfCnpj());
            statement.setString(4, cliente.getInscrEstadualRG());
            statement.setLong(5, cliente.getTelefone1());
            statement.setLong(6, cliente.getTelefone2());
            statement.setString(7, cliente.getEmail());
            statement.setString(8, cliente.getAtivProfissao());
            statement.setString(9, cliente.getCep());
            statement.setString(10, cliente.getEstado());
            statement.setString(11, cliente.getCidade());
            statement.setString(12, cliente.getRua());
            statement.setString(13, cliente.getNumero());
            statement.setString(14, cliente.getComplemento());
            statement.setString(15, cliente.getBairro());
            statement.setString(16, cliente.getSiteInstagram());
            statement.setString(17, cliente.getObservacoes());
            statement.setInt(18, cliente.getCodigo());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Cliente> listar(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        try{
            String sql = "SELECT * FROM public.tb_cliente;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigo(result.getInt("codigo"));
                cliente.setPfPj(result.getString("pf_pj"));
                cliente.setRazaoSocial(result.getString("razao_social"));
                cliente.setCpfCnpj(result.getString("cpf_cnpj"));
                cliente.setInscrEstadualRG(result.getString("inscr_estadual_rg"));
                cliente.setTelefone1(result.getLong("telefone1"));
                cliente.setTelefone2(result.getLong("telefone2"));
                cliente.setEmail(result.getString("email"));
                cliente.setAtivProfissao(result.getString("ativ_profissao"));
                cliente.setCep(result.getString("cep"));
                cliente.setEstado(result.getString("estado"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setRua(result.getString("rua"));
                cliente.setNumero(result.getString("numero"));
                cliente.setComplemento(result.getString("complemento"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setSiteInstagram(result.getString("site_instagram"));
                cliente.setObservacoes(result.getString("observacoes"));
                clientes.add(cliente);
            }

            for (Cliente cliente: clientes){
                System.out.println(cliente.getCodigo() + " | " + cliente.getRazaoSocial() + " | " + cliente.getEmail() );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void delete(int codigo){
        try{
            String sql = "DELETE FROM public.tb_cliente WHERE codigo=?;";
            PreparedStatement statement =  connection.prepareStatement(sql);
            statement.setInt(1, codigo);
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
