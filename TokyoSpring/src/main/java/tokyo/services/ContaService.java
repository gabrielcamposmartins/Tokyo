package tokyo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tokyo.dto.ContaDto;
import tokyo.entity.Conta;
import tokyo.repositories.ContaRepository;

import java.util.List;

@Service
public class ContaService {
    private final ContaRepository contaRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta createConta(ContaDto contaDto) {
        return contaRepository.save(new Conta(contaDto));
    }

    public List<Conta> getContas() {
        return contaRepository.findAll();
    }
}
