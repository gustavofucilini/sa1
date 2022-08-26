package gust.com.sa1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import gust.com.sa1.exception.RegistroNaoEncontradoException;

@SpringBootApplication
public class InitApp {
	
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
	@Bean
	public Hibernate5Module jsonHibernate5Module() {
		return new Hibernate5Module();
	}
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			try {
				//usuarioService.buscarPor("admin", "admin");
			} catch (RegistroNaoEncontradoException e) {
				/*Usuario admin = new Usuario();
				admin.setLogin("admin");
				admin.setSenha("admin");
				admin.setPerfil(Perfil.GESTOR);
				usuarioService.inserirAdmin(admin);*/
			}
			
		};
	}

}
