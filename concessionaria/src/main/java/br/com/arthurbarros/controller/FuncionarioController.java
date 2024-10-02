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

import br.com.arthurbarros.entity.Funcionario;
import br.com.arthurbarros.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    List<Funcionario> create(@RequestBody Funcionario funcionario) {
        return funcionarioService.create(funcionario);
    }
    
    @GetMapping
    List<Funcionario> list() {
        return funcionarioService.list();
    }

    @PutMapping
    List<Funcionario> update(@RequestBody Funcionario funcionario) {
        return funcionarioService.update(funcionario);
    }

    @DeleteMapping("{Codigo_Funcionario}")
    List<Funcionario> delete(@PathVariable("Codigo_Funcionario") int Codigo_Funcionario) {
        return funcionarioService.delete(Codigo_Funcionario);
    }
}