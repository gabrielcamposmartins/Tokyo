package tokyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tokyo.entity.Conta;
import tokyo.entity.Transferencia;
import tokyo.repositories.ContaRepository;
import tokyo.repositories.TransferenciaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(ContaRepository contaRepository, TransferenciaRepository transferenciaRepository) {
        return args -> {
            Conta conta1 = new Conta();
            conta1.setId(4511087482L);
            conta1.setSaldo(BigDecimal.valueOf(1000));

            Conta conta2 = new Conta();
            conta2.setId(5296652845L);
            conta2.setSaldo(BigDecimal.valueOf(2000));

            contaRepository.save(conta1);
            contaRepository.save(conta2);

            Transferencia transferencia1 = new Transferencia();
            transferencia1.setOrigem(conta1);
            transferencia1.setDestino(conta2);
            transferencia1.setValor(BigDecimal.valueOf(100));
            transferencia1.setTaxa(BigDecimal.valueOf(2.5));
            transferencia1.setDataAgendamento(LocalDate.now());
            transferencia1.setDataTransferencia(LocalDate.now());
            transferencia1.setEfetuada(false);

            Transferencia transferencia2 = new Transferencia();
            transferencia2.setOrigem(conta2);
            transferencia2.setDestino(conta1);
            transferencia2.setValor(BigDecimal.valueOf(200));
            transferencia2.setTaxa(BigDecimal.valueOf(5));
            transferencia2.setDataAgendamento(LocalDate.now());
            transferencia2.setDataTransferencia(LocalDate.now().plusDays(2));
            transferencia2.setEfetuada(false);

            transferenciaRepository.save(transferencia1);
            transferenciaRepository.save(transferencia2);
        };
    }
}