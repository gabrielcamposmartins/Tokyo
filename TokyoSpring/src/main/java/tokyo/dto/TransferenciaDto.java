package tokyo.dto;

import tokyo.entity.Conta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransferenciaDto {

    private Long origem;

    private Long destino;

    private BigDecimal valor;

    private String dataTransferencia;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TransferenciaDto() {
    }

    public Long getOrigem() {
        return origem;
    }

    public void setOrigem(Long origem) {
        this.origem = origem;
    }

    public Long getDestino() {
        return destino;
    }

    public void setDestino(Long destino) {
        this.destino = destino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataTransferencia() {
        return LocalDate.parse(dataTransferencia, formatter);
    }

    public void setDataTransferencia(String dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }
}
