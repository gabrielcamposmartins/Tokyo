package tokyo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tokyo.dto.ContaDto;
import tokyo.entity.Conta;
import tokyo.services.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<Conta> createConta(@RequestBody ContaDto conta) {
        Conta contaCriada = contaService.createConta(conta);
        return ResponseEntity.ok(contaCriada);
    }
}
