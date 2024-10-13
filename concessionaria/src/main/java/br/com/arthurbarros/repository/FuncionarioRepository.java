package br.com.arthurbarros.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.arthurbarros.entity.Funcionario;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    Optional<Funcionario> findByCpf(String cpf);

}
    

