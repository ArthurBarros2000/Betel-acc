package br.com.arthurbarros.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.arthurbarros.entity.Funcionario;
import br.com.arthurbarros.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> create(Funcionario funcionario) { 
        funcionarioRepository.save(funcionario);
        return list();
    }

    public List<Funcionario> list() {
        Sort sort = Sort.by("nome").ascending()
                       .and(Sort.by("cargo").ascending());
        return funcionarioRepository.findAll(sort);
    }

    public List<Funcionario> update(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return list();
    }

    public List<Funcionario> delete(int codigoFuncionario) {
        funcionarioRepository.deleteById(codigoFuncionario);
        return list();
    }
}