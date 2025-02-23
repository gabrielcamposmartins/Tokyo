package tokyo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private double id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal saldo;
}
