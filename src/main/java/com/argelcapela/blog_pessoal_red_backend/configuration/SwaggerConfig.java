package com.argelcapela.blog_pessoal_red_backend.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.argelcapela.blog_pessoal_red_backend.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metadata())
				.useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, responseMessage())
				.globalResponses(HttpMethod.POST, responseMessage())
				.globalResponses(HttpMethod.PUT, responseMessage())
				.globalResponses(HttpMethod.DELETE, responseMessage());

	}

	private List<Response> responseMessage() {
		return new ArrayList<Response>()
		{
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseBuilder().code("200").description("Sucesso!").build());
				add(new ResponseBuilder().code("201").description("Criado!").build());
				add(new ResponseBuilder().code("400").description("Erro na requisição!").build());
				add(new ResponseBuilder().code("401").description("Não Autorizado!").build());
				add(new ResponseBuilder().code("403").description("Proibido!").build());
				add(new ResponseBuilder().code("404").description("Não Encontrado!").build());
				add(new ResponseBuilder().code("500").description("Erro!").build());
			}
		};
	}

	private ApiInfo metadata() {		
		return new ApiInfoBuilder()
				.title("blog-pessoal-red-backend")
				.description("Exercício de criação de API. Permite realizar CRUD(s) entre as tabelas TEMA, POSTAGEM e USUÁRIO. Muito útil para praticar requisições e as funcionalidades básicas de uma nova tecnologia. Desenvolvido durante o bootcamp da Generation Brasil.")
				.version("1.0")
				.license("")
				.licenseUrl("https://github.com/argelcapela/gen_blog_pessoal_backend")
				.contact(contact())
				.build();
	}

	private Contact contact() {
		return new Contact("Argel Capela", "http://github.com/argelcapela", "argelcapeladossantos@gmail.com");
	}
	
	
}
