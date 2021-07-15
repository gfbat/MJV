package ghost.service;

import ghost.exceptions.CampoObrigatorioException;
import ghost.exceptions.RegistroNaoLocalizadoException;
import ghost.model.Cadastro;
import ghost.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository repository;

    public void incluir(Cadastro cadastro){
        if(cadastro.getCpf() == null){
            throw new CampoObrigatorioException("CPF");
        }
        repository.save(cadastro);
    }

    public Cadastro buscar(Integer id) throws RegistroNaoLocalizadoException {
        Optional<Cadastro> opt = repository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        } else {
            throw new RegistroNaoLocalizadoException("Cadastro", id);
        }
    }
}
