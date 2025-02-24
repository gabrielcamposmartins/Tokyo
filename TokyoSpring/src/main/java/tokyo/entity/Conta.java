package tokyo.entity;

import tokyo.dto.ContaDto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal saldo;

    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            this.id = generateId();
        }
    }

    public Conta() {
    }

    public Conta(Long id) {
        this.id = id;
    }

    public Conta(ContaDto dto) {
        this.saldo = dto.getSaldo();
    }

    private Long generateId() {
        return 1000000000L + (long) (Math.random() * 9000000000L);
    }


    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
