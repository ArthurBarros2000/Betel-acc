package br.com.arthurbarros.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.arthurbarros.entity.Carro;
import br.com.arthurbarros.repository.CarroRepository;

@Service
public class CarroService {
private CarroRepository carroRepository;
    
public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }



 public List<Carro> create(Carro carro) { 
    carroRepository.save(carro);
    return list();

 }
 public List<Carro> list() {
  Sort sort = Sort.by("marca").ascending()
  .and(Sort.by("cor").ascending())
  .and(Sort.by("modelo").ascending());
   return carroRepository.findAll(sort);
}

 public List<Carro> update(Carro carro) {
   carroRepository.save(carro);
   return list();

 }
 public List<Carro> delete(int codigoCarro) {
   carroRepository.deleteById(codigoCarro);
   return list();

 }
 

}


