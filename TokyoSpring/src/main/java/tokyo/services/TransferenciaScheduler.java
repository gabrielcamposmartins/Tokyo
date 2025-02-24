package tokyo.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tokyo.repositories.TransferenciaRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class TransferenciaScheduler {
    private final TransferenciaRepository transferenciaRepository;
    private final TransferenciaService transferenciaService;


    public TransferenciaScheduler(TransferenciaRepository transferenciaRepository, TransferenciaService transferenciaService) {
        this.transferenciaRepository = transferenciaRepository;
        this.transferenciaService = transferenciaService;
    }

    @Scheduled(fixedRate = 5000)
    public void processarTransferencias() {
        transferenciaRepository.findAllByEfetuadaFalseAndDataTransferencia(LocalDate.now())
                .forEach(transferenciaService::processarTransferencia);
    }
}
