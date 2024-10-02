package br.com.arthurbarros.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.arthurbarros.entity.Moto;
import br.com.arthurbarros.repository.MotoRepository;

@Service
public class MotoService {
    private final MotoRepository motoRepository;

    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public List<Moto> create(Moto moto) { 
        motoRepository.save(moto);
        return list();
    }

    public List<Moto> list() {
        Sort sort = Sort.by("Marca").ascending()
                       .and(Sort.by("Modelo").ascending())
                       .and(Sort.by("Nome").ascending());
        return motoRepository.findAll(sort);
    }

    public List<Moto> update(Moto moto) {
        motoRepository.save(moto);
        return list();
    }

    public List<Moto> delete(int Codigo_Moto) {
        motoRepository.deleteById(Codigo_Moto);
        return list();
    }
}