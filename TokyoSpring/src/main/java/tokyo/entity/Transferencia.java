package tokyo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import tokyo.dto.TransferenciaDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transferencia")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origem_id", nullable = false)
    private Conta origem;

    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Conta destino;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal taxa;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "dta_transferencia", nullable = false)
    private LocalDate dataTransferencia;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "dta_agendamento", nullable = false)
    private LocalDate dataAgendamento = LocalDate.now();

    @Column(nullable = false)
    private boolean efetuada = false;

    public Transferencia() {
    }

    public Transferencia(TransferenciaDto dto) {
        this.origem = new Conta(dto.getOrigem());
        this.destino = new Conta(dto.getDestino());
        this.valor = dto.getValor();
        this.dataTransferencia = dto.getDataTransferencia();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getOrigem() {
        return origem;
    }

    public void setOrigem(Conta origem) {
        this.origem = origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public void setDestino(Conta destino) {
        this.destino = destino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDate dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public boolean isEfetuada() {
        return efetuada;
    }

    public Transferencia setEfetuada(boolean efetuada) {
        this.efetuada = efetuada;
        return this;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
}
