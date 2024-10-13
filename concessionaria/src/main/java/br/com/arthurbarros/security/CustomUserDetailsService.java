package br.com.arthurbarros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import br.com.arthurbarros.entity.Funcionario;
import br.com.arthurbarros.repository.FuncionarioRepository;
import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private FuncionarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     
   Funcionario funcionario = this.repository.findByCpf(username).orElseThrow(() -> new UsernameNotFoundException("Funcionário não encontrado"));
   return new org.springframework.security.core.userdetails.User(funcionario.getCpf(), funcionario.getSenha(), new ArrayList<>());
    }
    
}
