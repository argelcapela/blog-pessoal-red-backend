package com.argelcapela.blog_pessoal_red_backend.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.argelcapela.blog_pessoal_red_backend.model.Usuario;
import com.argelcapela.blog_pessoal_red_backend.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService { 
/* It is used by the DaoAuthenticationProvider to load details about the user during authentication. */

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Usuario> user = userRepository.findByLogin(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found. "));
		
		return user.map(UserDetailsImpl::new).get();
	}
}
