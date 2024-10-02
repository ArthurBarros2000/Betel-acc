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

import br.com.arthurbarros.entity.Moto;
import br.com.arthurbarros.service.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {
    private MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @PostMapping
    List<Moto> create(@RequestBody Moto moto) {
        return motoService.create(moto);
    }
    
    @GetMapping
    List<Moto> list() {
        return motoService.list();
    }

    @PutMapping
    List<Moto> update(@RequestBody Moto moto) {
        return motoService.update(moto);
    }

    @DeleteMapping("{Codigo_Moto}")
    List<Moto> delete(@PathVariable("Codigo_Moto") int Codigo_Moto) {
        return motoService.delete(Codigo_Moto);
    }
}