package ghost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ghost.model.Curso;
import ghost.repository.CursoRepository;

import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	@Autowired
	private CursoRepository repository;
	
	@GetMapping
	public Iterable<Curso> listar(){
		return repository.findAll();
	}
	
	@PostMapping()
	public void incluir(@RequestBody Curso curso){
		repository.save(curso);
	}
	
	@PutMapping()
	public void alterar(@RequestBody Curso curso){
		repository.save(curso);
	}
	
	@GetMapping (value = "/filter/{nome}")
	public Iterable<Curso> listar(@PathVariable("nome") String nome){
		return repository.findByNomeContaining(nome);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	@DeleteMapping()
	public void deleteByParam(@RequestParam("id") Integer id, @RequestParam("nome") String nome ) {
		repository.deleteById(id);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Curso> buscar(@PathVariable("id") Integer id){
		Optional<Curso> opt = repository.findById(id);
		if(opt.isPresent()){
			return new ResponseEntity<Curso>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		//return repository.findById(id).orElse(null);
		/*
		Optional<Curso> opt = repository.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
			*/
	}
}
