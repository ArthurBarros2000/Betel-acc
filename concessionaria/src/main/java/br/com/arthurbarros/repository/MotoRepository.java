package br.com.arthurbarros.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.arthurbarros.entity.Moto;



public interface MotoRepository extends JpaRepository<Moto, Integer> {
    
}

