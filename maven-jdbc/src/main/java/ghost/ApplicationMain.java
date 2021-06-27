package ghost;

import ghost.dao.CadastroDAO;
import ghost.dao.ClienteDAO;
import ghost.model.Cadastro;
import ghost.model.Cliente;

public class ApplicationMain {
    public static void main(String[] args) {
        //CadastroDAO dao = new CadastroDAO();

//        Cadastro cadastro = new Cadastro();
//        cadastro.setNome("Jason Todd");
//        cadastro.setTelefone(1199998777L);
//        dao.incluir(cadastro);

//        Cadastro cadastro2 = new Cadastro();
//        cadastro2.setNome("TESTE");
//        cadastro2.setTelefone(888123781L);
//        cadastro2.setId(3);
//        dao.alterar(cadastro2);

        //dao.delete(3);
        //dao.listar();


        ClienteDAO clienteDAO = new ClienteDAO();
//        Cliente cliente = new Cliente();
//
//        cliente.setCodigo(1);
//        cliente.setPfPj("F");
//        cliente.setRazaoSocial("Ghost");
//        cliente.setCpfCnpj("36089371723");
//        cliente.setInscrEstadualRG("390446716");
//        cliente.setTelefone1(977230444L);
//        cliente.setTelefone2(977231144L);
//        cliente.setEmail("ghost@mail.com");
//        cliente.setAtivProfissao("Developer");
//        cliente.setCep("04689000");
//        cliente.setEstado("SP");
//        cliente.setCidade("SP");
//        cliente.setRua("Unknown Street");
//        cliente.setNumero("1939");
//        cliente.setComplemento("");
//        cliente.setBairro("Gotham City");
//        cliente.setSiteInstagram("@ghost");
//        cliente.setObservacoes("Observações sendo feitas neste campo");
//
//        clienteDAO.incluir(cliente);

//        Cliente cliente2 = new Cliente();
//
//        cliente2.setCodigo(1);
//        cliente2.setPfPj("J");
//        cliente2.setRazaoSocial("Ghostbatz");
//        cliente2.setCpfCnpj("36089371723");
//        cliente2.setInscrEstadualRG("390446716");
//        cliente2.setTelefone1(977230444L);
//        cliente2.setTelefone2(977231144L);
//        cliente2.setEmail("ghost@mail.com");
//        cliente2.setAtivProfissao("Developer");
//        cliente2.setCep("04689000");
//        cliente2.setEstado("SP");
//        cliente2.setCidade("SP");
//        cliente2.setRua("Unknown Street");
//        cliente2.setNumero("1939");
//        cliente2.setComplemento("");
//        cliente2.setBairro("Gotham City");
//        cliente2.setSiteInstagram("@ghost");
//        cliente2.setObservacoes("Observações sendo feitas neste campo");
//
//        clienteDAO.alterar(cliente2);

        clienteDAO.listar();
    }
}
