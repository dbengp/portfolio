package br.com.webvendas.webcomanda.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.webvendas.webcomanda.entities.Cliente;
import br.com.webvendas.webcomanda.repositories.ClienteRepository;

import java.util.Arrays;


@Configuration
@Profile("dev")
public class DevProfileConfig implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		Cliente primeiro = new Cliente(null, "Primeiro Cliente", "primeiro_c@devmail.com", "9191111111");
		Cliente segundo = new Cliente(null, "Segundo Cliente", "segundo_c@devgmail.com", "9192222222");
		Cliente terceiro = new Cliente(null, "Terceiro Cliente", "terceiro_c@devmail.com", "9193333333");
		Cliente quarto = new Cliente(null, "Quarto Cliente", "quarto_c@devmail.com", "9194444444");
		Cliente quinto = new Cliente(null, "Quinto Cliente", "quinto_c@devmail.com", "9195555555");

		clienteRepository.saveAll(Arrays.asList(primeiro, segundo, terceiro, quarto, quinto));
		
	}
}