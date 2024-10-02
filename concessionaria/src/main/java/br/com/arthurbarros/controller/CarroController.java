package br.com.arthurbarros.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthurbarros.entity.Carro;
import br.com.arthurbarros.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
    private CarroService carroService;


    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

@PostMapping
    List<Carro> create(@RequestBody Carro carro){
       return  carroService.create(carro);

    }
    
@GetMapping
    List<Carro> list() {
        return carroService.list();

    }
    @PutMapping
    List<Carro> update(@RequestBody Carro carro) {
        return carroService.update(carro);

    }
    @DeleteMapping("{Codigo_Carro}")
    List<Carro> delete(@PathVariable("Codigo_Carro") int Codigo_Carro) {
        return carroService.delete(Codigo_Carro);

    }

}
