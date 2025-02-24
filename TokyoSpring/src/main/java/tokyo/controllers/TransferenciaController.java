package tokyo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tokyo.dto.TransferenciaDto;
import tokyo.entity.Transferencia;
import tokyo.services.TransferenciaService;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<Transferencia> createTransferencia(@RequestBody TransferenciaDto transferenciaDto) {
        Transferencia transferencia = transferenciaService.createTransferencia(transferenciaDto);
        return ResponseEntity.ok(transferencia);
    }
}
