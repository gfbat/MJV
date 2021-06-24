package ghost;

import ghost.dao.CadastroDAO;
import ghost.model.Cadastro;

public class ApplicationMain {
    public static void main(String[] args) {
        CadastroDAO dao = new CadastroDAO();

        Cadastro cadastro = new Cadastro();
        cadastro.setNome("Jason Todd");
        cadastro.setTelefone(1199998777L);
        dao.incluir(cadastro);

//        Cadastro cadastro2 = new Cadastro();
//        cadastro2.setNome("TESTE");
//        cadastro2.setTelefone(888123781L);
//        cadastro2.setId(3);
//        dao.alterar(cadastro2);

        //dao.delete(3);
        dao.listar();

    }
}
