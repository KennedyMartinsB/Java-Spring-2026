package io.github.cursodsousa.produtosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;

public class ProdutosApiApplication {


	@GetMapping("/hello")
	public String helloWorld(){
		return "Olá Mundo!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProdutosApiApplication.class, args);
	}

}
