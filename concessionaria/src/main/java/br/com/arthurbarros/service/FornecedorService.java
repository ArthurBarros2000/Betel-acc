package br.com.arthurbarros.service;



import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.arthurbarros.entity.Fornecedor;
import br.com.arthurbarros.repository.FornecedorRepository;

@Service
public class FornecedorService {
    private FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Fornecedor> create(Fornecedor fornecedor) { 
        fornecedorRepository.save(fornecedor);
        return list();
    }

    public List<Fornecedor> list() {
        Sort sort = Sort.by("nomeEmpresa").ascending()
                       .and(Sort.by("endereco").ascending());
        return fornecedorRepository.findAll(sort);
    }

    public List<Fornecedor> update(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
        return list();
    }

    public List<Fornecedor> delete(int codigoFornecedor) {
        fornecedorRepository.deleteById(codigoFornecedor);
        return list();
    }
}
