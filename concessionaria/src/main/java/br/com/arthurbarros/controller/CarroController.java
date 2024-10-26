package br.com.arthurbarros.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/carro")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CarroController {
    private CarroService carroService;


    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

@PostMapping
    List<Carro> create(@RequestBody @Valid Carro carro){
       return  carroService.create(carro);

    }
    
@GetMapping
    List<Carro> list() {
        return carroService.list();

    }
    @PutMapping("/{codigoCarro}")
    public List<Carro> update(@PathVariable Integer codigoCarro, @RequestBody Carro carro) {
        carro.setCodigoCarro(codigoCarro);  
        return carroService.update(carro);

    }
    @DeleteMapping("/{codigoCarro}")
    List<Carro> delete(@PathVariable("codigoCarro") Integer codigoCarro) {
        return carroService.delete(codigoCarro);

    }

}
