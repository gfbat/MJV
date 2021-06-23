package ghost;

import ghost.dao.CadastroDAO;
import ghost.model.Cadastro;

public class ApplicationMain {
    public static void main(String[] args) {
        CadastroDAO dao = new CadastroDAO();

        Cadastro cadastro = new Cadastro();
        cadastro.setNome("Bruce Wayne");
        cadastro.setTelefone(11977042333L);
        dao.incluir(cadastro);
    }
}
