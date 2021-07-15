package ghost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ghost.model.Aluno;

public interface AlunoDao extends JpaRepository<Aluno, Integer> {
	
}
