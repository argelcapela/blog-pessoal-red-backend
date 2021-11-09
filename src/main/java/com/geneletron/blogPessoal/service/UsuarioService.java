package com.geneletron.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.geneletron.blogPessoal.model.Usuario;
import com.geneletron.blogPessoal.model.UsuarioLogin;
import com.geneletron.blogPessoal.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario usuario)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenhaUsuario());
		usuario.setSenhaUsuario(senhaEncoder);
		return repository.save(usuario);
	}
	
	/*public Usuario AtualizarUsuario(Usuario usuario)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenhaUsuario());
		usuario.setSenhaUsuario(senhaEncoder);
		return repository.save(usuario);
	}*/
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByLogin(user.get().getLogin());
		
		if (usuario.isPresent())
		{
			if (encoder.matches(user.get().getSenhaUsuario(), usuario.get().getSenhaUsuario())) // equipara dois valores(a que vem do json, é a do banco criptografada)
			{
				String auth = user.get().getLogin() + ":" + user.get().getSenhaUsuario();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNomeCompleto(usuario.get().getNomeCompleto());
				user.get().setSenhaUsuario(usuario.get().getSenhaUsuario());
				
				user.get().setTipo(usuario.get().getTipo());
				user.get().setFoto(usuario.get().getFoto());
				
				return user;
			}
		}
		return null;
	}
}
