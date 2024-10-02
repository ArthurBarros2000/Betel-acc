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

import br.com.arthurbarros.entity.Cliente;
import br.com.arthurbarros.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    List<Cliente> create(@RequestBody Cliente cliente) {
        return clienteService.create(cliente);
    }
    
    @GetMapping
    List<Cliente> list() {
        return clienteService.list();
    }

    @PutMapping
    List<Cliente> update(@RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }

    @DeleteMapping("{Codigo_Cliente}")
    List<Cliente> delete(@PathVariable("Codigo_Cliente") int Codigo_Cliente) {
        return clienteService.delete(Codigo_Cliente);
    }
}