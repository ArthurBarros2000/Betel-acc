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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public List<Funcionario> create(@RequestBody @Valid  Funcionario funcionario) {
        return funcionarioService.create(funcionario);
    }
    
    @GetMapping
    public List<Funcionario> list() {
        return funcionarioService.list();
    }

    @PutMapping("/{codigoFuncionario}")
    public List<Funcionario> update(@PathVariable Integer codigoFuncionario, @RequestBody Funcionario funcionario) {
        funcionario.setCodigoFuncionario(codigoFuncionario);
        return funcionarioService.update(funcionario);
    }

    @DeleteMapping("/{codigoFuncionario}")
    public List<Funcionario> delete(@PathVariable Integer codigoFuncionario) {
        return funcionarioService.delete(codigoFuncionario);
    }
}