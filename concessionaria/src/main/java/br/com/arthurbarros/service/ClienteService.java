package br.com.arthurbarros.service;



import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.arthurbarros.entity.Cliente;
import br.com.arthurbarros.repository.ClienteRepository;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> create(Cliente cliente) { 
        clienteRepository.save(cliente);
        return list();
    }

    public List<Cliente> list() {
        Sort sort = Sort.by("Nome").ascending()
                       .and(Sort.by("Endereco").ascending());
        return clienteRepository.findAll(sort);
    }

    public List<Cliente> update(Cliente cliente) {
        clienteRepository.save(cliente);
        return list();
    }

    public List<Cliente> delete(int Codigo_Cliente) {
        clienteRepository.deleteById(Codigo_Cliente);
        return list();
    }
}