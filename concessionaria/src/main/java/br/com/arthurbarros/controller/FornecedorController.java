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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    
    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    List<Fornecedor> create(@RequestBody @Valid  Fornecedor fornecedor) {
        return fornecedorService.create(fornecedor);
    }

    @GetMapping
    List<Fornecedor> list() {
        return fornecedorService.list();
    }

    @PutMapping("/{codigoFornecedor}")
    public List<Fornecedor> update(@PathVariable Integer codigoFornecedor, @RequestBody Fornecedor fornecedor) {
        fornecedor.setCodigoFornecedor(codigoFornecedor);
        return fornecedorService.update(fornecedor);
    }

    @DeleteMapping("{codigoFornecedor}")
    List<Fornecedor> delete(@PathVariable("codigoFornecedor") Integer codigoFornecedor) {
        return fornecedorService.delete(codigoFornecedor);
    }
}