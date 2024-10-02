package br.com.arthurbarros.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.arthurbarros.entity.Funcionario;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
    

