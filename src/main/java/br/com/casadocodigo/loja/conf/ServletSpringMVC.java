package br.com.casadocodigo.loja.conf;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.casadocodigo.loja.controllers.JPAConfiguration;

//classe que faz as configurações básicas do Spring


public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class}; // pegando minhas classes de configuração
	}

	@Override
	protected String[] getServletMappings() {
	
		return new String[] {"/"}; // mapeando o Servlet do Spring (tudo o que vier após o "/")
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {//configurando envio de arquivos
		registration.setMultipartConfig(new MultipartConfigElement(""));
		//dizendo que do jeito que eu recebo o arquivo, eu quero enviá-lo para o servidor
	}
	
	
}
