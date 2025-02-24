package tokyo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tokyo.dto.TransferenciaDto;
import tokyo.entity.Conta;
import tokyo.entity.Transferencia;
import tokyo.repositories.ContaRepository;
import tokyo.repositories.TransferenciaRepository;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class TransferenciaService {
    private final TransferenciaRepository transferenciaRepository;
    private final ContaRepository contaRepository;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    public TransferenciaService(TransferenciaRepository transferenciaRepository, ContaRepository contaRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.contaRepository = contaRepository;
    }

    public Transferencia createTransferencia(TransferenciaDto transferenciaDto) {
        Transferencia transferencia = new Transferencia(transferenciaDto);
        return transferenciaRepository.save(calcularTaxa(transferencia));
    }

    public Transferencia calcularTaxa(Transferencia transferencia) {
        long diasDiferenca = ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia());
        BigDecimal taxaFinal = BigDecimal.ZERO;
        BigDecimal valor = transferencia.getValor();

        if (diasDiferenca == 0) {
            taxaFinal = BigDecimal.valueOf(3).add(valor.multiply(BigDecimal.valueOf(0.025)));
        } else if (diasDiferenca >= 1 && diasDiferenca <= 10) {
            taxaFinal = BigDecimal.valueOf(12);
        } else if (diasDiferenca >= 11 && diasDiferenca <= 20) {
            taxaFinal = valor.multiply(BigDecimal.valueOf(0.082));
        } else if (diasDiferenca >= 21 && diasDiferenca <= 30) {
            taxaFinal = valor.multiply(BigDecimal.valueOf(0.069));
        } else if (diasDiferenca >= 31 && diasDiferenca <= 40) {
            taxaFinal = valor.multiply(BigDecimal.valueOf(0.047));
        } else if (diasDiferenca >= 41 && diasDiferenca <= 50) {
            taxaFinal = valor.multiply(BigDecimal.valueOf(0.017));
        }

        transferencia.setTaxa(taxaFinal);
        return transferencia;
    }

    @Transactional
    public void processarTransferencia(Transferencia transferencia) {
        Conta origem = contaRepository.findById(transferencia.getOrigem().getId()).orElseThrow();
        Conta destino = contaRepository.findById(transferencia.getDestino().getId()).orElseThrow();

        if (origem.getSaldo().compareTo(transferencia.getValor().add(transferencia.getTaxa())) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        origem.setSaldo(origem.getSaldo().subtract(transferencia.getValor().add(transferencia.getTaxa())));
        destino.setSaldo(destino.getSaldo().add(transferencia.getValor().add(transferencia.getTaxa())));

        contaRepository.save(origem);
        contaRepository.save(destino);
        transferenciaRepository.save(transferencia.setEfetuada(true));
    }
}
