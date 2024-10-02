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

import br.com.arthurbarros.entity.Fornecedor;
import br.com.arthurbarros.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    List<Fornecedor> create(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.create(fornecedor);
    }
    
    @GetMapping
    List<Fornecedor> list() {
        return fornecedorService.list();
    }

    @PutMapping
    List<Fornecedor> update(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.update(fornecedor);
    }

    @DeleteMapping("{Codigo_Fornecedor}")
    List<Fornecedor> delete(@PathVariable("Codigo_Fornecedor") int Codigo_Fornecedor) {
        return fornecedorService.delete(Codigo_Fornecedor);
    }
}