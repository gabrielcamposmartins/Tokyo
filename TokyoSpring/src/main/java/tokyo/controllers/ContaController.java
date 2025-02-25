package tokyo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tokyo.dto.ContaDto;
import tokyo.entity.Conta;
import tokyo.services.ContaService;

import java.util.List;

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

    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<List<Conta>> getContas() {
        List<Conta> contas = contaService.getContas();
        return ResponseEntity.ok(contas);
    }
}
