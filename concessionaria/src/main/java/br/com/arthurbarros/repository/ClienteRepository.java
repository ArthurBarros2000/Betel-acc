package br.com.arthurbarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.arthurbarros.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

    

