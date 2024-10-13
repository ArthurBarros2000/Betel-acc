package br.com.arthurbarros.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthurbarros.dto.LoginRequestDTO;
import br.com.arthurbarros.dto.RegisterRequestDTO;
import br.com.arthurbarros.dto.ResponseDTO;
import br.com.arthurbarros.entity.Funcionario;
import br.com.arthurbarros.repository.FuncionarioRepository;
import br.com.arthurbarros.security.TokenService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final FuncionarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    

    @PostMapping("/login") 
    public ResponseEntity login(@RequestBody LoginRequestDTO body ) {
        Funcionario funcionario = this.repository.findByCpf(body.cpf()).orElseThrow(() -> new RuntimeException ("Funcionário não encontrado"));
        if (passwordEncoder.matches(funcionario.getSenha(), body.senha())) {
            String token = this.tokenService.generateToken(funcionario);
            return ResponseEntity.ok(new ResponseDTO (funcionario.getNome(), token));
            
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register") 
    public ResponseEntity register(@RequestBody RegisterRequestDTO body ) {

        Optional<Funcionario> funcionario = this.repository.findByCpf(body.cpf());
        if (funcionario.isEmpty()) {

            Funcionario newfuncionario = new Funcionario();
            newfuncionario.setSenha(passwordEncoder.encode(body.senha()));
            newfuncionario.setCpf(body.cpf());
            newfuncionario.setNome(body.nome());
            this.repository.save(newfuncionario);

            
                String token = this.tokenService.generateToken(newfuncionario);
                return ResponseEntity.ok(new ResponseDTO (newfuncionario.getNome(), token));
                
        
            
            
        }


        
       
        return ResponseEntity.badRequest().build();
    }
}
