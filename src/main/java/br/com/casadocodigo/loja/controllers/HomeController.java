package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() { //ANOTATION
		System.out.println("Entrando na HOME da CDS");
		return "home"; // retornando a tela de inicialização
	}

}
