package ghost.controller;

import ghost.model.Aluno;
import ghost.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public Iterable<Aluno> listar() {
        return repository.findAll();
    }

    @PostMapping
    public void incluir(@RequestBody Aluno aluno) {
        repository.save(aluno);
    }

    @PutMapping
    public void alterar(@RequestBody Aluno aluno){
        repository.save(aluno);
    }


}
