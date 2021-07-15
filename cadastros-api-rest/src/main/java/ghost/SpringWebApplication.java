package ghost;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import ghost.model.Curso;
import ghost.model.enums.Nivel;
import ghost.repository.CursoRepository;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}


	@Bean
    public CommandLineRunner run(CursoRepository repository) throws Exception {
        return args -> {
        	Curso curso = new Curso();
        	curso.setCargaHoraria(60);
        	curso.setNivel(Nivel.AV);
        	curso.setNome("JAVA COM ENFANSE EM SPRINGBOOT");
        	//repository.save(curso);
        	ObjectMapper mapper = new ObjectMapper();
        	String json = mapper.writeValueAsString(curso);
        	System.out.println(json);
        };
    }

	@Bean
	public OpenAPI customOpenApi(@Value("${application.description}") String description){
		return new OpenAPI().info(new Info()
				.title(description)
				.version("1.0")
				.termsOfService("http://swagger.io/terms")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
	
}
