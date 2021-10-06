package service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import model.Usuario;
import model.UsuarioLogin;
import repository.UsuarioRepository;

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario usuario)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenhaUsuario());
		return repository.save(usuario);
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByLogin(user.get().getLogin());
		
		if (usuario.isPresent())
		{
			if (encoder.matches(user.get().getSenhaUsuario(), usuario.get().getSenhaUsuario()))
			{
				String auth = user.get().getLogin() + ":" + user.get().getSenhaUsuario();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic" + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNomeCompleto(usuario.get().getNomeCompleto());
				user.get().setSenhaUsuario(usuario.get().getSenhaUsuario());
				
				return user;
			}
		}
		return null;
	}
}
